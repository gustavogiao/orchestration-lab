package com.example.orchestration.models;

import java.time.LocalDateTime;

public class TransportRequest {

    private int id;
    private String origin;
    private String destination;
    private LocalDateTime departureTime;
    private int passengers;
    private double cost;
    private String status;

    public TransportRequest() {};

    public TransportRequest(int id, String origin, String destination, LocalDateTime departureTime, int passengers, double cost, String status){
        this.id = id;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.passengers = passengers;
        this.cost = cost;
        this.status = "PENDING";
    }

    public int getId() { return id; }
    public String getOrigin() { return origin; }
    public String getDestination() { return destination; }
    public LocalDateTime getDepartureTime() { return departureTime; }
    public int getPassengers() { return passengers; }
    public double getCost() { return cost; }
    public String getStatus() { return status; }

    public void setId(int id) { this.id = id; }
    public void setOrigin(String origin) { this.origin = origin; }
    public void setDestinatio(String destination) { this.destination = destination; }
    public void setDepartureTime(LocalDateTime departureTime) { this.departureTime = departureTime; }
    public void setPassengers(int passengers) { this.passengers = passengers; }
    public void setCost(double cost) { this.cost = cost; }
    public void setStatus(String status) { this.status = status; }


}
