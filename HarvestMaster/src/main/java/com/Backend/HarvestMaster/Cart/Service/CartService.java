package com.Backend.HarvestMaster.Cart.Service;

import com.Backend.HarvestMaster.Cart.Model.CartItem;
import com.Backend.HarvestMaster.Cart.Model.CartItemDTO;
import com.Backend.HarvestMaster.Cart.Model.Discount;

import java.util.List;

public interface CartService {
    CartItem saveCartItem(CartItem cartItem);

    List<CartItemDTO> findAllCartItems(Integer customerId);

    boolean deleteCartItem(Integer id);

    CartItemDTO updateQuantity(Integer cartItemId, CartItemDTO cartItemDTO);

    boolean deleteAll(Integer id);

    Discount saveDiscount(Discount discount);


    List<Discount> getAllDiscount();
}
