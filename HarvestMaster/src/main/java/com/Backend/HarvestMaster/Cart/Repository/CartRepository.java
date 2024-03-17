package com.Backend.HarvestMaster.Cart.Repository;

import com.Backend.HarvestMaster.Cart.Model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<CartItem, Integer> {
}
