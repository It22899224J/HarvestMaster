package com.Backend.HarvestMaster.PaddyStocks.Service;

import com.Backend.HarvestMaster.PaddyStocks.Model.PaddyStock;
import com.Backend.HarvestMaster.PaddyStocks.Model.PaddyStockDTO;
import com.Backend.HarvestMaster.PaddyStocks.Model.PaddyStockViewDTO;
import com.Backend.HarvestMaster.PaddyStocks.Repository.PaddyStockRepository;
import com.Backend.HarvestMaster.PostHarvest.Model.PostHarvest;
import com.Backend.HarvestMaster.PostHarvest.Repository.PostHarvestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PaddyStockImpl implements PaddyStockService{


    @Autowired
    private PaddyStockRepository paddyStockRepository;


    @Autowired
    private PostHarvestRepository postHarvestRepository;
    @Override

    public  List<PaddyStockViewDTO> getPaddyStockDetails(int fieldId) {


        paddyStockRepository.findByRelatedPostHarvest_FieldId(fieldId);


        List<PaddyStock> paddyStocks =  paddyStockRepository.findByRelatedPostHarvest_FieldId(fieldId);
        List<PaddyStockViewDTO> paddyStockViewDTOs = paddyStocks.stream()
                .map(this::convertToviewDTO)
                .collect(Collectors.toList());


        return paddyStockViewDTOs;



    }

    @Override
    public List<PaddyStockDTO> getAllPaddyStockDetails() {

        List<PaddyStock> paddyStocks = paddyStockRepository.findAll();
        List<PaddyStockDTO> paddyStockDTOs = paddyStocks.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());


        return paddyStockDTOs;
    }

    @Override
    public boolean deletePaddyStock(int paddystock_id) {
        paddyStockRepository.deleteById(paddystock_id);
        return true;
    }

    @Override
    public PaddyStock updateStock(int paddystock_id,PaddyStock paddyStock) {
        return paddyStockRepository.save(paddyStock);
    }


    @Override
    public PaddyStock addPaddyStock(Integer fieldId,PaddyStock paddyStock) {

        Optional<PostHarvest> optionalPostHarvest = postHarvestRepository.findById(fieldId);
        if (optionalPostHarvest.isPresent()) {
            PostHarvest postHarvest = optionalPostHarvest.get();

            // Set the relevant PostHarvest field in the new PaddyStock object
           paddyStock.setRelatedPostHarvest(postHarvest);

            // Save the new PaddyStock
            return paddyStockRepository.save(paddyStock);
        } else {
            // Handle the case when the PostHarvest entity is not found
            throw new RuntimeException("PostHarvest with fieldId " + fieldId + " not found.");

    }
    }


    private PaddyStockDTO convertToDTO(PaddyStock paddyStock) {
        PaddyStockDTO dto = new PaddyStockDTO();
        dto.setPs_id(paddyStock.getPs_id());
        dto.setAmount(paddyStock.getAmount());
        dto.setPrice(paddyStock.getPrice());
        dto.setStatus(paddyStock.getStatus());



        // Convert image data to Base64

        dto.setImageBase64(blobConverter(paddyStock));

        // Populate fields from the associated PostHarvest object
        PostHarvest postHarvest = paddyStock.getRelatedPostHarvest();
        if (postHarvest != null) {
            dto.setPaddyVariety(postHarvest.getPaddyVareity());
            dto.setLocation(postHarvest.getLocation());
            // Add other fields as needed
        }

        return dto;
    }

    private PaddyStockViewDTO convertToviewDTO(PaddyStock paddyStock) {
        PaddyStockViewDTO dto = new PaddyStockViewDTO();
        dto.setPs_id(paddyStock.getPs_id());
        dto.setAmount(paddyStock.getAmount());
        dto.setPrice(paddyStock.getPrice());
        dto.setStatus(paddyStock.getStatus());



        // Convert image data to Base64

        dto.setImage(blobConverter(paddyStock));

        // Populate fields from the associated PostHarvest object
        PostHarvest postHarvest = paddyStock.getRelatedPostHarvest();
        if (postHarvest != null) {
            dto.setRelatedPostHarvest(postHarvest);
        }

        return dto;
    }
    private String blobConverter(PaddyStock paddyStock){
        String imageBase64 = null;
        Blob imageBlob = paddyStock.getImage();
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
