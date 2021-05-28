package com.lmolina.service;

import com.lmolina.model.PaymentResponse;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class PaymentServiceTest {

    @Test
    public  void payment_is_correct(){
        PaymentGatewayInterface paymentGatewayInt = Mockito.mock(PaymentGatewayInterface.class);
        Mockito.when(paymentGatewayInt.requestPayment(Mockito.any())).thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.OK));

        PaymentService paymentService = new PaymentService(paymentGatewayInt);
        boolean result = paymentService.makePayment(1000);
        assertTrue(result);
    }

    @Test
    public  void payment_is_incorrect(){
        PaymentGatewayInterface paymentGatewayInt = Mockito.mock(PaymentGatewayInterface.class);
        Mockito.when(paymentGatewayInt.requestPayment(Mockito.any())).thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.ERROR));

        PaymentService paymentService = new PaymentService(paymentGatewayInt);
        boolean result = paymentService.makePayment(1000);
        assertFalse(result);
    }
}