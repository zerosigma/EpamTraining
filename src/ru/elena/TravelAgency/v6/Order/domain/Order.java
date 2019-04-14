package ru.elena.TravelAgency.v6.Order.domain;

import ru.elena.TravelAgency.v5.City.domain.City;
import ru.elena.TravelAgency.v5.Order.domain.Currency;
import ru.elena.TravelAgency.v5.User.domain.User;
import ru.elena.TravelAgency.v5.common.business.domain.BaseDomain;

import java.util.List;

public class Order extends BaseDomain<Long> {
    private User user;
    private Integer price;
    private Currency currency;
    private List<City> citiesInOrder;

    public Order() {}

    public Order(User user, Integer price, List<City> cities) {
        this.user = user;
        this.price = price;
        this.citiesInOrder = cities;
        this.currency = Currency.RUB;
    }

    public Order(User user, Integer price, List<City> cities, Currency currency) {
        this.user = user;
        this.price = price;
        this.citiesInOrder = cities;
        this.currency = currency;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<City> getCitiesInOrder() {
        return citiesInOrder;
    }

    public void setCitiesInOrder(List<City> citiesInOrder) {
        this.citiesInOrder = citiesInOrder;
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
        return "Order{" +
                "user=" + user +
                ", price=" + price +
                ", currency=" + currency +
                ", citiesInOrder=" + citiesInOrder +
                '}';
    }
}
