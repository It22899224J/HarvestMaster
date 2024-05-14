package com.Backend.HarvestMaster.PaymentHandle.Service;

import com.Backend.HarvestMaster.Buyer.Repositiory.BuyerRepositiory;
import com.Backend.HarvestMaster.Inventory.Model.Inventory;
import com.Backend.HarvestMaster.Inventory.Repository.InventoryRepository;
import com.Backend.HarvestMaster.LogisticHandler.Model.Buyer;
import com.Backend.HarvestMaster.Order.Model.*;
import com.Backend.HarvestMaster.Order.Repository.DeliveryRepository;
import com.Backend.HarvestMaster.PaymentHandle.Model.SucessTransactionResponse;
import com.Backend.HarvestMaster.PaymentHandle.Model.TransactionPayment;
import com.Backend.HarvestMaster.PaymentHandle.Model.TransactionPaymentRequest;
import com.Backend.HarvestMaster.PaymentHandle.Repositiory.TransactionPaymentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TransactionPaymentServiceImpl implements TransactionPaymentService {
    private final TransactionPaymentRepository transactionPaymentRepository;
    private final DeliveryRepository deliveryRepository;
    private final InventoryRepository inventoryRepository;
    private final BuyerRepositiory buyerRepositiory;

    public TransactionPaymentServiceImpl(TransactionPaymentRepository transactionPaymentRepository, DeliveryRepository deliveryRepository, InventoryRepository inventoryRepository, BuyerRepositiory buyerRepositiory) {
        this.transactionPaymentRepository = transactionPaymentRepository;
        this.deliveryRepository = deliveryRepository;
        this.inventoryRepository = inventoryRepository;
        this.buyerRepositiory = buyerRepositiory;
    }

    public TransactionPayment saveTransaction(TransactionPaymentRequest transactionPaymentRequest) {
        TransactionPayment transactionPayment = mapToEntity(transactionPaymentRequest);
        return transactionPaymentRepository.save(transactionPayment);
    }

    private TransactionPayment mapToEntity(TransactionPaymentRequest transactionPaymentRequest) {
        TransactionPayment transactionPayment = new TransactionPayment();

        Delivery delivery = deliveryRepository.findDeliveryByDeliveryId((transactionPaymentRequest.getDeliveryId()));
        if (delivery == null) {
            throw new IllegalArgumentException("Invalid deliveryId: " + transactionPaymentRequest.getDeliveryId());
        }

        Inventory inventory = inventoryRepository.findById((transactionPaymentRequest.getInventoryId()));
        if (inventory == null) {
            throw new IllegalArgumentException("Invalid inventoryId: " + transactionPaymentRequest.getInventoryId());
        }

        Buyer buyer = buyerRepositiory.findById((transactionPaymentRequest.getBuyerId()));
        if (buyer == null) {
            throw new IllegalArgumentException("Invalid buyerId: " + transactionPaymentRequest.getBuyerId());
        }

        transactionPayment.setDelivery(delivery);
        transactionPayment.setInventory(inventory);
        transactionPayment.setQuantity(transactionPaymentRequest.getQuantity());
        transactionPayment.setPricePerUnit(transactionPaymentRequest.getPricePerUnit());
        transactionPayment.setTotalPrice(transactionPaymentRequest.getTotalPrice());
        transactionPayment.setTransactionDate(transactionPaymentRequest.getTransactionDate());
        transactionPayment.setBuyer(buyer);
        transactionPayment.setPaymentMethod(transactionPaymentRequest.getPaymentMethod());
        transactionPayment.setStatus(transactionPaymentRequest.getStatus());

        if ("CARD".equals(transactionPaymentRequest.getPaymentMethod())) {
            transactionPayment.setPaymentSuccessCode(transactionPaymentRequest.getPaymentSuccessCode());
            transactionPayment.setStatus("VERIFY");
        } else if ("SLIP".equals(transactionPaymentRequest.getPaymentMethod())) {
            String bankSlipImageString = transactionPaymentRequest.getBankSlipImage();
            if (bankSlipImageString == null) {
                throw new IllegalArgumentException("Bank slip image data is missing");
            }
            String cleanBankSlipImage = transactionPaymentRequest.getBankSlipImage().replace(":", "");
            byte[] imageData = Base64.getEncoder().encode(cleanBankSlipImage.getBytes());
            transactionPayment.setBankSlipImage(imageData);
            transactionPayment.setStatus("PENDING");
        } else {
            throw new IllegalArgumentException("Unsupported payment method: " + transactionPaymentRequest.getPaymentMethod());
        }
        return transactionPayment;
    }

    @Override
    public List<SucessTransactionResponse> sucessTransaction(TransactionPaymentRequest transactionPaymentRequest) {
        List<TransactionPayment> allTransactionPayments = transactionPaymentRepository.findAll();
        return allTransactionPayments.stream()
                .filter(transactionPayment -> "VERIFY".equals(transactionPaymentRequest.getStatus()))
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<SucessTransactionResponse> sucessTransactionAll() {
        List<TransactionPayment> allTransactionPayments = transactionPaymentRepository.findAll();
        return allTransactionPayments.stream()
//                .filter(transactionPayment -> "VERIFY".equals(transactionPayment.getStatus()))
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

//    @Override
//    public List<TransactionPaymentRequest> getTransactionById(Long deliveryId) {
//        List<TransactionPayment> getTransactionPayment = transactionPaymentRepository.findAll();
//        return getTransactionPayment.stream()
//                .filter(transactionPayment ->
//                        transactionPayment.getBuyer() != null && // Ensure Buyer object is not null
//                                deliveryId == transactionPayment.getDelivery().getDeliveryId()) // Directly compare int values
//                .map(this::convertToDto)
//                .collect(Collectors.toList());
//    }

    @Override
    public List<SucessTransactionResponse> getTransactionById(Long deliveryId) {
        Optional<TransactionPayment> transactionOptional = transactionPaymentRepository.findAll().stream()
                .filter(transactionPayment ->
                        transactionPayment.getBuyer() != null && // Ensure Buyer object is not null
                                deliveryId.equals(transactionPayment.getDelivery().getDeliveryId())) // Use equals() for Long comparison
                .findFirst();

        return transactionOptional.map(transactionPayment -> Collections.singletonList(convertToDto(transactionPayment)))
                .orElse(Collections.emptyList());
    }


    private SucessTransactionResponse convertToDto(TransactionPayment transactionPayment) {
        SucessTransactionResponse dto = new SucessTransactionResponse();
        dto.setTransactionId(transactionPayment.getTransactionId());
        dto.setPaymentMethod(transactionPayment.getPaymentMethod());
        dto.setTotalPrice(transactionPayment.getTotalPrice());
        dto.setTransactionDate(formatLocalDateTime(transactionPayment.getTransactionDate()));
        dto.setTotalPrice(transactionPayment.getTotalPrice());
        dto.setStatus(transactionPayment.getStatus());
        dto.setBankSlipImage(Base64.getEncoder().encodeToString(transactionPayment.getBankSlipImage()));
        dto.setPaymentSuccessCode(transactionPayment.getPaymentSuccessCode());
        return dto;
    }

    private String formatLocalDateTime(LocalDateTime localDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return localDateTime.format(formatter);
    }
}
