package com.example.orchestration.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.orchestration.models.Order;
import com.example.orchestration.services.OrchestratorServiceB;


@RestController
@RequestMapping("/orchestratorB")
public class OrchestratorControllerB {
   
    private final OrchestratorServiceB service;

    public OrchestratorControllerB(OrchestratorServiceB s) {
        this.service = s;
    }

    @PostMapping
    public ResponseEntity<?> process(@RequestBody Order order) {
        return service.process(order);
    }
}
