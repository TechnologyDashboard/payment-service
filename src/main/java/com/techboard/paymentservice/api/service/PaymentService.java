package com.techboard.paymentservice.api.service;

import com.techboard.paymentservice.api.entity.Payment;
import com.techboard.paymentservice.api.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public Payment savePayment(Payment payment){
        payment.setPaymentStatus(paymentProcessing());
        payment.setTransactionId(UUID.randomUUID().toString());
        return paymentRepository.save(payment);

    }
    public  String paymentProcessing(){
        //API call to 3rd party payment gateway to paypal paytm
        return new Random().nextBoolean()?"succes":"false";
    }

    public Payment findPaymentByOrderId(int orderId) {
        return paymentRepository.findByOrderId(orderId);
    }
}
