package com.example.orchestration.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.orchestration.models.Order;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody Order order){
        
        if(order.quantity <= 0 || order.price <= 0){
            return ResponseEntity.badRequest().body("Dados Inválidos");
        }

        double total = order.quantity * order.price;

        return ResponseEntity.ok(total);
        
    }

}
