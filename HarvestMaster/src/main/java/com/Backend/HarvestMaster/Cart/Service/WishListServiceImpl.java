package com.Backend.HarvestMaster.Cart.Service;

import com.Backend.HarvestMaster.Cart.Model.CartItem;
import com.Backend.HarvestMaster.Cart.Model.CartItemDTO;
import com.Backend.HarvestMaster.Cart.Model.WishList;
import com.Backend.HarvestMaster.Cart.Model.WishListDTO;
import com.Backend.HarvestMaster.Cart.Repository.WishListRepository;
import com.Backend.HarvestMaster.Inventory.Model.Inventory;
import com.Backend.HarvestMaster.Inventory.Model.InventoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WishListServiceImpl implements WishListService{
    @Autowired
    private WishListRepository wishListRepository;
    @Override
    public WishList saveItem(WishList wishList) {
        return wishListRepository.save(wishList);
    }

    @Override
    public boolean deleteItem(Integer id) {
        if(wishListRepository.findById(id).isPresent()){
            wishListRepository.deleteById(id);
            return true;
        }

        return false;
    }

    @Override
    public List<WishListDTO> findAllItems(Integer customerId) {

        List<WishList> wishListItems = wishListRepository.getItemList(customerId);

        return wishListItems.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());

    }

    private WishListDTO convertToDTO(WishList wishList) {
        WishListDTO dto = new WishListDTO();
        dto.setItemId(wishList.getItemId());
        dto.setAvailability(wishList.getAvailability());

        // Convert Inventory to InventoryDTO
        dto.setInventoryDTO(convertInventoryToDTO(wishList.getInventory()));
        dto.setBuyer(wishList.getBuyer());
        return dto;
    }

    private InventoryDTO convertInventoryToDTO(Inventory inventory) {
        InventoryDTO dto = new InventoryDTO();
        dto.setImage(blobConverter(inventory));

        dto.setPId(inventory.getPId());
        dto.setPrice(inventory.getPrice());
        dto.setDescription(inventory.getDescription());
        dto.setProduct_Name(inventory.getProduct_Name());
        dto.setPackege_Type(inventory.getPackege_Type());
        dto.setProduct_type(inventory.getProduct_type());

        return dto;
    }

    private String blobConverter(Inventory inventory) {
        String imageBase64 = null;
        Blob imageBlob = inventory.getImage();
        if (imageBlob != null) {
            try {
                int blobLength = (int) imageBlob.length();
                byte[] imageData = imageBlob.getBytes(1, blobLength);
                imageBase64 = Base64.getEncoder().encodeToString(imageData);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return imageBase64;
    }
}
