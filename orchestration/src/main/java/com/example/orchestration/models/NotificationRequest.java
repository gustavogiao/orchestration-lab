package com.example.orchestration.models;

public class NotificationRequest {

    private String clientName;
    private String clientEmail;
    private int orderId;
    private String orderStatus;

    public NotificationRequest() {}

    public NotificationRequest(String clientName, String clientEmail, int orderId, String orderStatus) {
        this.clientName = clientName;
        this.clientEmail = clientEmail;
        this.orderId = orderId;
        this.orderStatus = orderStatus;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}
