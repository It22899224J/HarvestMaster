package com.Backend.HarvestMaster.Cart.Service;

import com.Backend.HarvestMaster.Cart.Model.CartItem;

import java.util.List;

public interface CartService {
    CartItem saveCartItem(CartItem cartItem);

    List<CartItem> findAll(int customerId);

    boolean deleteCartItem(Integer id);
}
