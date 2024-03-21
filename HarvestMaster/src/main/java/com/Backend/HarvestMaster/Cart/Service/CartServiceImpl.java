package com.Backend.HarvestMaster.Cart.Service;

import com.Backend.HarvestMaster.Cart.Model.CartItem;
import com.Backend.HarvestMaster.Cart.Repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService{

    @Autowired
    private CartRepository cartRepository;

    @Override
    public CartItem saveCartItem(CartItem cartItem) {
        return cartRepository.save(cartItem);
    }

    @Override
    public List<CartItem> findAll(int customerId) {
        return null;
    }

    @Override
    public boolean deleteCartItem(Integer id) {
        cartRepository.deleteById(id);
        return true;
    }
}
