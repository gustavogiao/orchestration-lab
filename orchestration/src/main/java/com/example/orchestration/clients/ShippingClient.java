package com.example.orchestration.clients;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.orchestration.models.Shipping;

@Service
public class ShippingClient {

    private RestTemplate rest = new RestTemplate();

    public String ship() {
        Shipping s = new Shipping();
        s.address = "Rua do Caraças";

        return rest.postForObject("http://localhost:8080/shipping", s, String.class);
    }

}
