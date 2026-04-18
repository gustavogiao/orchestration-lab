package com.example.orchestration.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.orchestration.models.Shipping;

@RestController
@RequestMapping("/shipping")
public class ShippingController {

    @PostMapping
    public ResponseEntity<?> ship(@RequestBody Shipping shipping){

        if(shipping.address == null){
            return ResponseEntity.badRequest().body("Morada Inválida.");
        }

        shipping.status = "Enviado.";

        return ResponseEntity.ok(shipping.status);
    }

    @GetMapping("/{id}")
    public String status() {
        return "Em trânsito";
    }

}
