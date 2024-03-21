package com.Backend.HarvestMaster.Cart.Controller;

import com.Backend.HarvestMaster.Cart.Model.CartItem;
import com.Backend.HarvestMaster.Cart.Service.CartService;
import com.Backend.HarvestMaster.Inventory.Model.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = "/api/harvestMaster")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping(path = "/cart")
    public ResponseEntity<CartItem> addToCart(@RequestBody CartItem cartItem){

        return new ResponseEntity<>(cartService.saveCartItem(cartItem), HttpStatus.CREATED);
    }

    @GetMapping(path = "/cart/{customerId}")
    public List<CartItem> getAllCartItems(@PathVariable("customerId") Integer customerId){

        return null;
    }

    @DeleteMapping(path = "/cart/{id}")
    public ResponseEntity<CartItem> deleteCartItem(@PathVariable Integer id) {
        try {
            if (cartService.deleteCartItem(id)) {
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
