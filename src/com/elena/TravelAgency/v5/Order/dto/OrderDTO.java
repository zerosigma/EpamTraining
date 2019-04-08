package com.elena.TravelAgency.v5.Order.dto;

import com.elena.TravelAgency.v5.City.domain.City;
import com.elena.TravelAgency.v5.Order.domain.Currency;
import com.elena.TravelAgency.v5.User.domain.User;
import com.elena.TravelAgency.v5.common.business.dto.BaseDTO;

import java.util.List;

public class OrderDTO extends BaseDTO<Long> {
    private User user;
    private Integer price;
    private Currency currency;
    private List<City> citiesInOrder;

    public OrderDTO() {}

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
}
