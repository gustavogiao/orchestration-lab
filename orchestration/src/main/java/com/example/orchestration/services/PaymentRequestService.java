package com.example.orchestration.services;

import com.example.orchestration.models.PaymentRequest;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService(
    targetNamespace = "http://soap.transport.example.com/",
    serviceName = "PaymentService"
)
public class PaymentRequestService {

    @WebMethod
        public boolean processPayment(PaymentRequest request) {

            if(request.getAmount() <= 0){
                throw new RuntimeException("Valor inválido");
            }

            if(request.getCardNumber() == null || request.getCardNumber().length() != 16){
                throw new RuntimeException("Cartão inválido");
            }

            if(request.getCvv() == null || request.getCvv().length() != 3){
                throw new RuntimeException("CVV inválido");
            }

            return true;
        }
}
