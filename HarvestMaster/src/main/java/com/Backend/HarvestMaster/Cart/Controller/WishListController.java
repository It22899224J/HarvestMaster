package com.Backend.HarvestMaster.Cart.Controller;

import com.Backend.HarvestMaster.Cart.Model.CartItem;
import com.Backend.HarvestMaster.Cart.Model.CartItemDTO;
import com.Backend.HarvestMaster.Cart.Model.WishList;
import com.Backend.HarvestMaster.Cart.Model.WishListDTO;
import com.Backend.HarvestMaster.Cart.Service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = "/api/harvestMaster")
@CrossOrigin("http://localhost:5173")
public class WishListController {

    @Autowired
    private WishListService wishListService;

    @PostMapping(path = "/wishlist")
    public ResponseEntity<WishList> addToWishList(@RequestBody WishList wishList){
        return new ResponseEntity<>(wishListService.saveItem(wishList), HttpStatus.CREATED);
    }

    @GetMapping(path = "/wishlist/{customerId}")
    public List<WishListDTO> findAllItems(@PathVariable Integer customerId){

        return wishListService.findAllItems(customerId);
    }

    @DeleteMapping(path = "/wishlist/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable Integer id) {
        try {
            if (wishListService.deleteItem(id)) {
                return new ResponseEntity<>("delete success", HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
