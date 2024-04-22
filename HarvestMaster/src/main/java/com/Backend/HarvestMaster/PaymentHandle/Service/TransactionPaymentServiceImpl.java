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

import java.util.List;
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
            byte[] imageData = java.util.Base64.getDecoder().decode(transactionPaymentRequest.getPaymentMethod());
            transactionPayment.setBankSlipImage(imageData);
            transactionPayment.setStatus("PENDING");
        } else {
            throw new IllegalArgumentException("Unsupported payment method: " + transactionPaymentRequest.getPaymentMethod());
        }
        return transactionPayment;
    }

    @Override
    public List<TransactionPaymentRequest> sucessTransaction(TransactionPaymentRequest transactionPaymentRequest) {
        List<TransactionPayment> allTransactionPayments = transactionPaymentRepository.findAll();
        return allTransactionPayments.stream()
                .filter(transactionPayment -> "VERIFY".equals(transactionPaymentRequest.getStatus()))
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<TransactionPaymentRequest> sucessTransactionAll() {
        List<TransactionPayment> allTransactionPayments = transactionPaymentRepository.findAll();
        return allTransactionPayments.stream()
                .filter(transactionPayment -> "VERIFY".equals(transactionPayment.getStatus()))
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private TransactionPaymentRequest convertToDto(TransactionPayment transactionPayment) {
        TransactionPaymentRequest dto = new TransactionPaymentRequest();
        dto.setTransactionId(transactionPayment.getTransactionId());
        dto.setPaymentMethod(transactionPayment.getPaymentMethod());
        dto.setTotalPrice(transactionPayment.getTotalPrice());
        dto.setTransactionDate(transactionPayment.getTransactionDate());
//        dto.setAmount(transactionPayment.getAmount());
        dto.setStatus(transactionPayment.getStatus());
        return dto;
    }
}
