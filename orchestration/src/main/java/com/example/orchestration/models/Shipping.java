package com.example.orchestration.models;

public class Shipping {

    public String address;
    public String status;

    public Shipping() {}

    public Shipping(String address, String status){
        this.address = address;
        this.status = status;
    }

    public String getAddress() { return address; }
    public String getStatus() { return status; }

    public void setAddress(String address) { this.address = address; }
    public void setStatus(String status) { this.status = status; }
}
