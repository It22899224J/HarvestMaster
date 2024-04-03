package com.Backend.HarvestMaster.Inventory.Service;

import com.Backend.HarvestMaster.Inventory.Model.Inventory;
import com.Backend.HarvestMaster.Inventory.Model.InventoryDTO;
import com.Backend.HarvestMaster.Inventory.Repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;
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



    @Override
    public Inventory updateInventory(Integer p_id, Inventory inventory) {

        inventory.setPId(p_id);
        inventoryRepository.save(inventory);
        return inventory;
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
}


