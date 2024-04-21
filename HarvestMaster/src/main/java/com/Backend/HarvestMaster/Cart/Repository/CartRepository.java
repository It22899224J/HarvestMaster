package com.Backend.HarvestMaster.Cart.Repository;

import com.Backend.HarvestMaster.Cart.Model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<CartItem, Integer> {

    @Query(value = "select * from cart_items where customer_id = ?1", nativeQuery = true)
    List<CartItem> getCartItemList(Integer customer_Id);

//    @Modifying
//    @Query(value = "")

}
