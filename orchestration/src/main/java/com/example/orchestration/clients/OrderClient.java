package com.example.orchestration.clients;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.orchestration.models.Order;

@Service
public class OrderClient {

    private RestTemplate rest = new RestTemplate();

    public Double createOrder(Order order) {
        return rest.postForObject("http://localhost:8080/orders", order, Double.class);
    }
}
