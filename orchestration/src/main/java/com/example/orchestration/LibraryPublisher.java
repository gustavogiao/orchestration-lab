package com.example.orchestration;

import com.example.orchestration.services.LibraryService;

import jakarta.xml.ws.Endpoint;

public class LibraryPublisher {

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8081/library", new LibraryService());

        System.out.println("SOAP Service running at http://localhost:8081/library");
    }
}