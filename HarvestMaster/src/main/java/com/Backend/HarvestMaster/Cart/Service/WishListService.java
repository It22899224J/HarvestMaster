package com.Backend.HarvestMaster.Cart.Service;

import com.Backend.HarvestMaster.Cart.Model.WishList;
import com.Backend.HarvestMaster.Cart.Model.WishListDTO;

import java.util.List;

public interface WishListService {
    WishList saveItem(WishList wishList);

    boolean deleteItem(Integer id);

    List<WishListDTO> findAllItems(Integer customerId);
}
