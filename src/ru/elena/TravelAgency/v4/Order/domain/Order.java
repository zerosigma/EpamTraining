package ru.elena.TravelAgency.v4.Order.domain;

import ru.elena.TravelAgency.v4.common.domain.BaseDomain;

import java.util.Objects;

public class Order extends BaseDomain {
    private Integer price;
    private Currency currency;

    private Order(Long id, Integer price) {
        this.id = id;
        this.price = price;
        this.currency = Currency.RUB;
    }

    public Order(Long id, Integer price, Currency currency) {
        this.id = id;
        this.price = price;
        this.currency = currency;
    }

    private enum Currency {
        RUB("Price in roubles (by default)"),
        USD("Price in dollar"),
        EUR("Price in euro");

        private String description;

        Currency(String description) {
            this.description = description;
        }
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
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
