package com.example.paymentservice.controller;

import com.stripe.model.Event;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stripeWebhook")
public class StripeWebhookController {

    @PostMapping
    public void stripeWebhook(@RequestBody Event event){
        int i=0;
        System.out.println("Stripe webhook endpoint " + i++);

        if(event.getType()=="payment_link.created"){
            System.out.println("payment_link.created");
        }
        if(event.getType()=="payment_intent.succeeded"){
            System.out.println("payment_intent.succeeded");
        }
        if(event.getType()=="payout.paid"){
            System.out.println("payout.paid");
        }

    }
}
