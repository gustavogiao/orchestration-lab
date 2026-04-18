package com.example.orchestration;

import com.example.orchestration.services.PaymentRequestService;

import jakarta.xml.ws.Endpoint;

public class PaymentRequestPublisher {
public static void main(String[] args) {

        Endpoint.publish(
            "http://localhost:8082/paymentRequest",
            new PaymentRequestService()
        );

        System.out.println("SOAP Payment running at http://localhost:8082/paymentRequest");
    }
}
