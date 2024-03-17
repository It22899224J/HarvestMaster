package com.Backend.HarvestMaster.Cart.Repository;

import com.Backend.HarvestMaster.Cart.Model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<CartItem, Integer> {
}
