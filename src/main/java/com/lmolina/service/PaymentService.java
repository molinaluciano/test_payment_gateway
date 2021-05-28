package com.lmolina.service;

import com.lmolina.model.PaymentRequest;
import com.lmolina.model.PaymentResponse;

public class PaymentService {
    private PaymentGatewayInterface paymentGateway;

    public PaymentService(PaymentGatewayInterface paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public boolean makePayment(double amount){
        PaymentResponse response = paymentGateway.requestPayment(new PaymentRequest(amount));
        if (response.getStatus() == PaymentResponse.PaymentStatus.OK) {
            return true;
        } else {
            return false;
        }
    }
}
