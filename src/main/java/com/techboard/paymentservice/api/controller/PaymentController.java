package com.techboard.paymentservice.api.controller;


import com.techboard.paymentservice.api.entity.Payment;
import com.techboard.paymentservice.api.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/doPayment")
    public Payment doPayment(@RequestBody Payment payment){
        System.out.println("inside do Payment controller==>"+payment);

        return paymentService.savePayment(payment);
    }

    @GetMapping("/{orderId}")
    public Payment findPaymentByOrderId(@PathVariable int orderId){

        return paymentService.findPaymentByOrderId(orderId);
    }


}
