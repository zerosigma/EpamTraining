package main.java.ru.elena.TravelAgency.v0;

public class Order {
    private Integer price;

    private Order(Integer price) {
        this.price = price;
    }

    public Integer getPrice() {
        return price;
    }
}
