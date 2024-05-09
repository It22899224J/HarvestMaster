package com.Backend.HarvestMaster.PaymentHandle.Service;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Balance;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    @Value("${stripe.secret}")
    private String apiKey;
    public PaymentIntent createPaymentIntent(String amount, String currency, String apiKey) throws StripeException {
        Stripe.apiKey = apiKey;

        PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
                .setAmount(Long.parseLong(amount))
                .setCurrency(currency)
                .build();

        return PaymentIntent.create(params);
    }

    public Balance retrieveBalance() throws StripeException {
        Stripe.apiKey = apiKey;
        return Balance.retrieve();
    }
}
