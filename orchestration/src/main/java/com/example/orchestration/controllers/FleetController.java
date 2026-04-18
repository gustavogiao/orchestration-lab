package com.example.orchestration.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.orchestration.models.TransportRequest;
import com.example.orchestration.services.FleetService;

@RestController
@RequestMapping("/fleet")
public class FleetController {

    private final FleetService service;

    public FleetController(FleetService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody TransportRequest req){
        try {
            return ResponseEntity.ok(service.create(req));
        } catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/confirm/{id}")
    public ResponseEntity<?> confirm(@PathVariable int id,
                                    @RequestParam boolean payment,
                                    @RequestParam boolean notified){

        return ResponseEntity.ok(service.confirm(id, payment, notified));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable int id){
        return ResponseEntity.ok(service.get(id));
    }

}
