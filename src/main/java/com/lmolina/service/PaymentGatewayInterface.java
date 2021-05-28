package com.lmolina.service;

import com.lmolina.model.PaymentRequest;
import com.lmolina.model.PaymentResponse;

public interface PaymentGatewayInterface {
    PaymentResponse requestPayment(PaymentRequest request);
}
