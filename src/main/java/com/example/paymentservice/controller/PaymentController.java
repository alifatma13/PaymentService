package com.example.paymentservice.controller;

import com.example.paymentservice.dtos.InitiatePaymentRequestDto;
import com.example.paymentservice.dtos.InitiatePaymentResponseDto;
import com.example.paymentservice.services.PaymentService;
import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    PaymentService paymentService;

    public  PaymentController(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    @PostMapping("/")
    public String initiatePayment(@RequestBody InitiatePaymentRequestDto requestDto) throws RazorpayException, StripeException {
        return paymentService.initiatePayment(requestDto.getOrderId(), requestDto.getAmount(),
                requestDto.getPhoneNumber(), requestDto.getEmail());
    }
}
