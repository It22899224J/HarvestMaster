package com.Backend.HarvestMaster.Cart.Controller;

import com.Backend.HarvestMaster.Cart.Model.CartItem;
import com.Backend.HarvestMaster.Cart.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/harvestMaster")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping(path = "/cart")
    public CartItem addToCart(@RequestBody CartItem cartItem){
        return cartService.saveCartItem(cartItem);
    }


}
