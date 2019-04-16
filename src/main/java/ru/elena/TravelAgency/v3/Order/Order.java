package main.java.ru.elena.TravelAgency.v3.Order;

import java.util.Objects;

public class Order {
    private Long id;
    private Integer price;

    private Order(Long id, Integer price) {
        this.id = id;
        this.price = price;
    }

    private enum Currency {
        RUB
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

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Order order = (Order) o;
        return id.equals(order.id) &&
                price.equals(order.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price);
    }
}
