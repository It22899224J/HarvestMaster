package com.Backend.HarvestMaster.Cart.Controller;

import com.Backend.HarvestMaster.Cart.Model.CartItem;
import com.Backend.HarvestMaster.Cart.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = "/api/harvestMaster")
@CrossOrigin("http://localhost:5173")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping(path = "/cart")
    public ResponseEntity<CartItem> addToCart(@RequestBody CartItem cartItem){

        return new ResponseEntity<>(cartService.saveCartItem(cartItem), HttpStatus.CREATED);
    }

    @GetMapping(path = "/cart/{customerId}")
    public List<CartItem> findAllCartItems(@PathVariable Integer customerId){

        return cartService.findAllCartItems(customerId);
    }

    @PatchMapping(path = "/cart/{cartItemId}")
    public ResponseEntity<CartItem> updateQuantity(
            @PathVariable Integer cartItemId,
            @RequestBody CartItem cartItem){

        return new ResponseEntity<>(cartService.updateQuantity(cartItemId, cartItem), HttpStatus.OK);
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
