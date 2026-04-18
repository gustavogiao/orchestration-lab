package com.example.orchestration.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.orchestration.services.OrchestratorService;

@RestController
@RequestMapping("/orchestrator")
public class OrchestratorController {

    private final OrchestratorService orchestrator;

    public OrchestratorController(OrchestratorService orchestrator) {
        this.orchestrator = orchestrator;
    }

    @GetMapping("/request/{id}")
    public ResponseEntity<?> request(@PathVariable int id) {
        return orchestrator.processRequest(id);
    }
}
