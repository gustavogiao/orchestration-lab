package com.example.orchestration.services;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService
public class PaymentService {

    @WebMethod
    public boolean proccessPayment(String card, String expiry, String cvv){

        if(card == null || cvv == null){
            return false;
        }

        return card.length() == 16; // fake
    }
    
}
