package com.elena.TravelAgency;

public class Order {
    private Integer price;

    private Order(Integer price) {
        this.price = price;
    }

    public Integer getPrice() {
        return price;
    }
}
