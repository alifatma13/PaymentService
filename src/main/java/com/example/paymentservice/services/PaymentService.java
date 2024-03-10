package com.example.paymentservice.services;

import com.example.paymentservice.paymentgateway.PaymentGateway;
import com.example.paymentservice.paymentgateway.RazorPayPaymentGateway;
import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private PaymentGateway paymentGateway;

    public PaymentService(@Qualifier("StripePaymentGateway") PaymentGateway paymentGateway){
        this.paymentGateway = paymentGateway;
    }

    public String initiatePayment(String orderId, Long amount, String phoneNumber, String email) throws StripeException, RazorpayException {
        // Need to call the order service to get the order details
        // But as of now we are hardcoding details
        // Order o = orderService.getOrderDetails(orderId);
        // int amount  = o.getAmount();
        //String productName = o.getProductName();
        //Long amount = 10000L;

        //Generate  the payment link
        return paymentGateway.generatePaymentLink(
                orderId, amount, phoneNumber, email
        );
    }
}
