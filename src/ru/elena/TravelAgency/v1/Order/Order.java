package ru.elena.TravelAgency.v1.Order;

public class Order {
    private Long id;
    private Integer price;

    private Order(Long id, Integer price) {
        this.id = id;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Order " +
                "id = " + id +
                ", price = " + price;
    }
}
