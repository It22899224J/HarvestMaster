package com.Backend.HarvestMaster.Cart.Service;

import com.Backend.HarvestMaster.Cart.Model.CartItem;
import com.Backend.HarvestMaster.Cart.Model.CartItemDTO;
import com.Backend.HarvestMaster.Cart.Model.Discount;
import com.Backend.HarvestMaster.Cart.Repository.CartRepository;
import com.Backend.HarvestMaster.Cart.Repository.DiscountRepository;
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
public class CartServiceImpl implements CartService{

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private DiscountRepository discountRepository;

    @Override
    public CartItem saveCartItem(CartItem cartItem) {
        cartItem.setTotalAmount(cartItem.calTotalAmount());
        return cartRepository.save(cartItem);
    }

    @Override
    public List<CartItemDTO> findAllCartItems(Integer customerId) {

        List<CartItem> cartItems = cartRepository.getCartItemList(customerId);

        return cartItems.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private CartItemDTO convertToDTO(CartItem cartItem) {
        CartItemDTO dto = new CartItemDTO();
        dto.setCartItemId(cartItem.getCartItemId());
        dto.setQuantity(cartItem.getQuantity());
        dto.setUnitPrice(cartItem.getUnitPrice());
        // Convert Inventory to InventoryDTO
        dto.setInventoryDTO(convertInventoryToDTO(cartItem.getInventory()));
        dto.setBuyer(cartItem.getBuyer());
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

    private String blobConverter(Inventory inventory){
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

    @Override
    public boolean deleteCartItem(Integer id) {
        cartRepository.deleteById(id);
        return true;
    }

    @Override
    public CartItemDTO updateQuantity(Integer cartItemId, CartItemDTO cartItemDTO) {

        CartItem existingCartItem = cartRepository.findById(cartItemId)
                .orElseThrow(() -> new RuntimeException("CartItem not found with ID: " + cartItemId));

        existingCartItem.setQuantity(cartItemDTO.getQuantity());

        InventoryDTO dto = convertInventoryToDTO(existingCartItem.getInventory());

        return new CartItemDTO(
                existingCartItem.getCartItemId(),
                existingCartItem.getQuantity(),
                existingCartItem.getUnitPrice(),
                dto,
                existingCartItem.getBuyer()
        );
    }

    @Override
    public boolean deleteAll(Integer id) {
        return false;
    }

    @Override
    public Discount saveDiscount(Discount discount) {
        return discountRepository.save(discount);
    }

    @Override
    public List<Discount> getAllDiscount() {
        return discountRepository.findAll();
    }
}
