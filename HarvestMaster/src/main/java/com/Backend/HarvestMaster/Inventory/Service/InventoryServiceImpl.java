package com.Backend.HarvestMaster.Inventory.Service;

import com.Backend.HarvestMaster.Inventory.Model.Inventory;
import com.Backend.HarvestMaster.Inventory.Model.InventoryDTO;
import com.Backend.HarvestMaster.Inventory.Model.Update_Inventory;
import com.Backend.HarvestMaster.Inventory.Repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InventoryServiceImpl implements InventoryService{

    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    public boolean deleteInventoryItem(int id) {
        inventoryRepository.deleteById(id);
        return true;
    }

    @Override
    public Inventory saveInventory(Inventory inventory){
        return inventoryRepository.save(inventory);
    }



    @Override
    public List<Inventory> getInventories() {
        return inventoryRepository.findAll();
    }

    @Override
    public List<InventoryDTO> getAllInventory() {

        List<Inventory> Inventory =  inventoryRepository.findAll();
        List<InventoryDTO> inventoryDTOS = Inventory.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());


        return inventoryDTOS;

    }







    public InventoryDTO updateInventory(Integer p_id, Update_Inventory updateInventory) {
        Optional<Inventory> optionalInventory = inventoryRepository.findById(p_id);
        if (optionalInventory.isPresent()) {
            Inventory inventory = optionalInventory.get();
            // Update the inventory details with the provided DT
            inventory.setDescription(updateInventory.getDescription());
            inventory.setPrice(updateInventory.getPrice());
            // Save the updated inventory
            inventoryRepository.save(inventory);
            // Convert the updated inventory back to DTO for response
            return convertToDTO(inventory);
        } else {
            // Handle the case where inventory with the provided ID is not found
            throw new NoSuchElementException("Inventory not found with ID: " + p_id);
        }
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

    private InventoryDTO convertToDTO(Inventory inventory) {
        InventoryDTO dto = new InventoryDTO();
       dto.setImage(blobConverter(inventory));

       dto.setPId(inventory.getPId());
       dto.setPrice(inventory.getPrice());
       dto.setDescription(inventory.getDescription());
       dto.setProduct_Name(inventory.getProduct_Name());
       dto.setPackege_Type(inventory.getPackege_Type());
       dto.setProduct_type(inventory.getProduct_type());



        // Populate fields from the associated PostHarvest object


        return dto;
    }

//    private InventoryDTO convertToDTOForUpdate(Inventory inventory) {
//        InventoryDTO dto = new InventoryDTO();
//        dto.setPId(inventory.getPId()); // Set the PID
//        dto.setProduct_Name(inventory.getProduct_Name());
//        dto.setDescription(inventory.getDescription());
//        dto.setPrice(inventory.getPrice());
//        // Exclude image data if it's not needed for update
//        return dto;
//    }
}


