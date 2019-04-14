package ru.elena.TravelAgency.v5.Order.dto;

import ru.elena.TravelAgency.v5.City.dto.CityDTO;
import ru.elena.TravelAgency.v5.Order.domain.Currency;
import ru.elena.TravelAgency.v5.User.dto.UserDTO;
import ru.elena.TravelAgency.v5.common.business.dto.BaseDTO;

import java.util.List;

public class OrderDTO extends BaseDTO<Long> {
    private UserDTO user;
    private Integer price;
    private Currency currency;
    private List<CityDTO> citiesInOrder;

    public OrderDTO() {}

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public List<CityDTO> getCitiesInOrder() {
        return citiesInOrder;
    }

    public void setCitiesInOrder(List<CityDTO> citiesInOrder) {
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
