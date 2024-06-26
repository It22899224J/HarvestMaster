package com.Backend.HarvestMaster.PaddyStocks.Service;

import com.Backend.HarvestMaster.PaddyStocks.Model.*;
import com.Backend.HarvestMaster.PaddyStocks.Repository.PaddyStockRepository;
import com.Backend.HarvestMaster.PostHarvest.Model.PostHarvest;
import com.Backend.HarvestMaster.PostHarvest.Model.PostHarvestAudit;
import com.Backend.HarvestMaster.PostHarvest.Repository.PostHarvestRepository;
import com.Backend.HarvestMaster.PostHarvest.Service.PostHarvestAuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PaddyStockImpl implements PaddyStockService{


    @Autowired
    private PaddyStockRepository paddyStockRepository;

    @Autowired BidService bidService;


    @Autowired
    private PostHarvestAuditService postHarvestAuditService;
    @Override

    public  List<PaddyStockViewDTO> getPaddyStockDetails(int fieldId) {





        List<PaddyStock> paddyStocks =  paddyStockRepository.findByRelatedPostHarvest_FieldId(fieldId);
        List<PaddyStockViewDTO> paddyStockViewDTOs = paddyStocks.stream()
                .map(this::convertToviewDTO)
                .collect(Collectors.toList());


        return paddyStockViewDTOs;



    }

    @Override
    public PaddyStock getPaddyStock(int stockid) {



        return  paddyStockRepository.findById(stockid).get();
    }

    @Override
    public List<PaddyStockAvl> getPaddyStocksByType(String vareity, String fertilizer) {




        List<PaddyStockAvl> resultList = paddyStockRepository.findByVareityAndFertilizer(vareity,fertilizer);



        return  resultList;



    }

    @Override
    public List<PaddyStockDTO> getAllPaddyStockDetails() {

        List<PaddyStock> paddyStocks = paddyStockRepository.findActiveStocks();
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
    public PaddyStockViewDTO updateStock(int paddystock_id,PaddyStock paddyStock) {

        PaddyStock existingStock = paddyStockRepository.findById(paddystock_id).get();
        if (existingStock!=null) {
            if (paddyStock.getImage() != null) {

                existingStock.setImage(paddyStock.getImage());
            }
            if (paddyStock.getPrice() != 0.0) {
                existingStock.setPrice(paddyStock.getPrice());
            }
            if (paddyStock.getAmount() != 0.0) {
                existingStock.setAmount(paddyStock.getAmount());
            }
            if (paddyStock.getStatus() != null) {
                existingStock.setStatus(paddyStock.getStatus());
            }

            paddyStockRepository.save(existingStock);

        return convertToviewDTO(existingStock);
    }





            else {
                // Handle case where PaddyStock with the given ID is not found
                throw new NoSuchElementException("PaddyStock with ID " + paddystock_id+ " not found");
            }






    }


    @Override
    public PaddyStockViewDTO addPaddyStock(Integer auditId,PaddyStock paddyStock) {

       PostHarvestAudit optionalPostHarvest = postHarvestAuditService.getAuditData(auditId);
        if (optionalPostHarvest!=null) {
            PostHarvestAudit postHarvestAudit = optionalPostHarvest;

            // Set the relevant PostHarvest field in the new PaddyStock object
           paddyStock.setRelatedPostHarvestaudit(postHarvestAudit);

            // Save the new PaddyStock
             paddyStockRepository.save(paddyStock);


            return convertToviewDTO(paddyStock);
        } else {
            // Handle the case when the PostHarvest entity is not found
            throw new RuntimeException("PostHarvest with fieldId " + auditId + " not found.");

    }
    }


    private PaddyStockDTO convertToDTO(PaddyStock paddyStock) {
        PaddyStockDTO dto = new PaddyStockDTO();
        dto.setPs_id(paddyStock.getPs_id());
        dto.setAmount(paddyStock.getAmount());
        dto.setPrice(paddyStock.getPrice());
        dto.setStatus(paddyStock.getStatus());
        dto.setStockCreationDate(paddyStock.getStockCreationDate());
        dto.setBids(bidService.getMarketBids(dto.getPs_id()));



        // Convert image data to Base64

        dto.setImageBase64(blobConverter(paddyStock));

        // Populate fields from the associated PostHarvest object
        PostHarvestAudit postHarvestAudit = paddyStock.getRelatedPostHarvestaudit();
        if (postHarvestAudit != null) {
            PostHarvest postHarvest = postHarvestAudit.getRelatedpostHarvest();

            if (postHarvest != null) {
                dto.setPaddyVariety(postHarvest.getPaddyVareity());
                dto.setLocation(postHarvest.getLocation());
                dto.setDistrict(postHarvest.getDistrict());
                // Add other fields as needed
            }
        }
        return dto;
    }

    public PaddyStockViewDTO convertToviewDTO(PaddyStock paddyStock) {
        PaddyStockViewDTO dto = new PaddyStockViewDTO();
        dto.setPs_id(paddyStock.getPs_id());
        dto.setAmount(paddyStock.getAmount());
        dto.setPrice(paddyStock.getPrice());
        dto.setStatus(paddyStock.getStatus());
        dto.setStockCreationDate(paddyStock.getStockCreationDate());



        // Convert image data to Base64

        dto.setImage(blobConverter(paddyStock));

        // Populate fields from the associated PostHarvest object
        PostHarvestAudit postHarvestAudit = paddyStock.getRelatedPostHarvestaudit();
        if (postHarvestAudit != null) {
            dto.setRelatedPostHarvestaudit(postHarvestAudit.getAuditId());
            dto.setRiceVareity(postHarvestAudit.getRelatedpostHarvest().getPaddyVareity());
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
