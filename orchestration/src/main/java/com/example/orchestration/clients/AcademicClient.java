package com.example.orchestration.clients;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class AcademicClient {
    private final RestTemplate restTemplate = new RestTemplate();

    public boolean checkEligibility(int id) {
        return restTemplate.getForObject("http://localhost:8080/academic/eligible/" + id,
        Boolean.class);
    }

    public ResponseEntity<?> requestCertificate(int id, boolean libraryClear) {
        try {
            return restTemplate.postForEntity(
                    "http://localhost:8080/academic/certificate/" + id,
                    libraryClear, // isto pode dar problema
                    Object.class);

        } catch (HttpClientErrorException e) {
            return ResponseEntity.status(e.getStatusCode())
                    .body(e.getResponseBodyAsString());
        }
    }
}
