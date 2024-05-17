package com.Backend.HarvestMaster.PaymentHandle.Controller;

import com.Backend.HarvestMaster.PaymentHandle.Model.TransferPay;
import com.Backend.HarvestMaster.PaymentHandle.Model.PaymentRequest;
import com.Backend.HarvestMaster.PaymentHandle.Service.PaymentService;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Balance;
import com.stripe.model.Charge;
import com.stripe.model.PaymentIntent;
import com.stripe.model.Transfer;
import com.stripe.param.ChargeCreateParams;
import com.stripe.param.TransferCreateParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Map;

@RestController
@RequestMapping("/api/payment/")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${stripe.secret}")
    private String stripeApiKey;


//    @PostMapping("/bank-transfer")
//    public ResponseEntity<String> transferMoney(@RequestParam String accountNumber,
//                                                @RequestParam String routingNumber,
//                                                @RequestParam double amount) {
//        Stripe.apiKey = stripeApiKey;
//        try {
//            // Create a transfer using the provided bank account details
//            TransferCreateParams params = TransferCreateParams.builder()
//                    .setAmount((long) (amount * 100)) // Amount in cents
//                    .setCurrency("lkr") // Using LKR currency
//                    .setDestination(
//                            TransferCreateParams.Destination.builder()
//                                    .setBankAccount(
//                                            TransferCreateParams.Destination.BankAccount.builder()
//                                                    .setAccountNumber(accountNumber)
//                                                    .setRoutingNumber(routingNumber)
//                                                    .build()
//                                    )
//                                    .build()
//                    )
//                    .build();
//
//            Transfer transfer = Transfer.create(params);
//            return ResponseEntity.ok("Transfer initiated successfully. Transfer ID: " + transfer.getId());
//        } catch (StripeException e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("Failed to initiate transfer: " + e.getMessage());
//        }
//    }



    @PostMapping("/create-payment-intent")
    public PaymentIntent createPaymentIntent(@RequestBody TransferPay payment) throws StripeException {
        return paymentService.createPaymentIntent(payment.getAmount(), payment.getCurrency(), stripeApiKey);
    }

    @PostMapping("/transfer")
    public ResponseEntity<String> processPayment(@RequestBody PaymentRequest request) {
        Stripe.apiKey = stripeApiKey;

        Double amountUSD = request.getAmount() * 0.0033;

        try {
            Charge charge = Charge.create(
                    new ChargeCreateParams.Builder()
                            .setAmount((long) (amountUSD * 100))
                            .setCurrency("usd")
                            .setSource(request.getToken())
                            .build()
            );

            // Payment successful, handle accordingly
            return ResponseEntity.ok(charge.getId());
        } catch (StripeException e) {
            // Payment failed, handle error
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Payment failed: " + e.getMessage());
        }
    }

    @PostMapping("/charge")
    public String charge(@RequestParam String token, @RequestParam int amount, @RequestParam String currency) {
        Stripe.apiKey = stripeApiKey;
        try {
            Charge charge = Charge.create(Map.of(
                    "amount", amount,
                    "currency", currency,
                    "source", token
            ));
            return "Payment successful: " + charge.getId();
        } catch (StripeException e) {
            e.printStackTrace();
            return "Payment failed: " + e.getMessage();
        }
    }

    // Assume 1 USD = 200 LKR for this example
    private static final double USD_TO_LKR_EXCHANGE_RATE = 200.0;

    @GetMapping("/balance")
    public String getBalanceInLKR() {
        Stripe.apiKey = stripeApiKey;
        try {
            // Retrieve balance in USD
            Balance balance = Balance.retrieve();

            // Convert balance to LKR
            long balanceInUSD = balance.getAvailable().get(0).getAmount(); // Assuming balance is in USD
            double balanceInLKR = balanceInUSD * USD_TO_LKR_EXCHANGE_RATE;

            return "Available balance: " + balanceInLKR + " LKR";
        } catch (StripeException e) {
            e.printStackTrace();
            return "Failed to retrieve balance: " + e.getMessage();
        }
    }

    private class BankAccount {
    }
}
