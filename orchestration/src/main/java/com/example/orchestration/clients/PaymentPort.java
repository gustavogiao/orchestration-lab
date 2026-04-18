package com.example.orchestration.clients;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService(
    targetNamespace = "http://services.orchestration.example.com/",
    name = "PaymentService"
)
public interface PaymentPort {
    @WebMethod
    boolean processPayment(String card, String expiry, String cvv);
}