package com.example.orchestration.clients;

import org.springframework.stereotype.Service;

import com.example.orchestration.soap.PaymentService;
import com.example.orchestration.soap.PaymentServiceService;

@Service
public class PaymentClient {

    public boolean pay() {

        PaymentServiceService service = new PaymentServiceService();

        PaymentService port = service.getPaymentServicePort();

        return port.proccessPayment("1234567890123456", "12/30", "123");
    }
}