package com.Backend.HarvestMaster.PaymentHandle.Model;

import com.Backend.HarvestMaster.Inventory.Model.Inventory;
import com.Backend.HarvestMaster.LogisticHandler.Model.Buyer;
import com.Backend.HarvestMaster.Order.Model.Delivery;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class TransactionPaymentRequest {
    private Long transactionId;
    private Long deliveryId;
    private int inventoryId;
    private Integer quantity;
    private BigDecimal pricePerUnit;
    private BigDecimal totalPrice;
    private LocalDateTime transactionDate;
    private int buyerId;
    private String paymentMethod;
    private String paymentSuccessCode;

    @JsonProperty("bank_slip_image")
    private String bankSlipImage;

    private String status;
}
