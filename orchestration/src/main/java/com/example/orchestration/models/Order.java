package com.example.orchestration.models;

public class Order {

    public String product;
    public int quantity;
    public double price;

    public Order() {};

    public Order(String product, int quantity, double price){
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }

    public String getProduct() { return product; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }

    public void setProduct(String product) { this.product = product; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setPrice(double price) { this.price = price; }

}
