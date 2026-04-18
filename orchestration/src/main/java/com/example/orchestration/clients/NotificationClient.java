package com.example.orchestration.clients;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificationClient {

    private RestTemplate rest = new RestTemplate();

    public String notify(String msg) {
        return rest.postForObject("http://localhost:8080/notify", msg, String.class);
    }
}
