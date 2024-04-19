package com.Backend.HarvestMaster.PaymentHandle.Service;

import com.Backend.HarvestMaster.Buyer.Repositiory.BuyerRepositiory;
import com.Backend.HarvestMaster.Inventory.Model.Inventory;
import com.Backend.HarvestMaster.Inventory.Repository.InventoryRepository;
import com.Backend.HarvestMaster.LogisticHandler.Model.Buyer;
import com.Backend.HarvestMaster.Order.Model.Delivery;
import com.Backend.HarvestMaster.Order.Repository.DeliveryRepository;
import com.Backend.HarvestMaster.PaymentHandle.Model.TransactionPayment;
import com.Backend.HarvestMaster.PaymentHandle.Model.TransactionPaymentRequest;
import com.Backend.HarvestMaster.PaymentHandle.Repositiory.TransactionPaymentRepository;
import org.springframework.stereotype.Service;

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
            transactionPayment.setBankSlipImage(transactionPaymentRequest.getBankSlipImage());
            transactionPayment.setStatus("PENDING");
        } else {
            throw new IllegalArgumentException("Unsupported payment method: " + transactionPaymentRequest.getPaymentMethod());
        }
        return transactionPayment;
    }
}
