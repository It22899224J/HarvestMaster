package com.Backend.HarvestMaster.Cart.Repository;

import com.Backend.HarvestMaster.Cart.Model.CartItem;
import com.Backend.HarvestMaster.Cart.Model.WishList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishListRepository extends JpaRepository<WishList, Integer> {

    @Query(value = "select * from wish_list_items where customer_id = ?1", nativeQuery = true)
    List<WishList> getItemList(Integer customer_Id);
}
