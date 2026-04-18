package com.example.orchestration.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notify")
public class NotificationController {

    @PostMapping
    public String notifyClient(@RequestBody String msg){
        return "Notificação enviada: " + msg;
    }
}
