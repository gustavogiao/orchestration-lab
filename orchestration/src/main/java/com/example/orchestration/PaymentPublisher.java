package com.example.orchestration;

import com.example.orchestration.services.PaymentService;

import jakarta.xml.ws.Endpoint;


public class PaymentPublisher {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8082/payment", new PaymentService());
    }
}
