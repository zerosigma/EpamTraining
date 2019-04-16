package main.java.ru.elena.TravelAgency.v6.User.dto;

import main.java.ru.elena.TravelAgency.v5.Order.domain.Order;
import main.java.ru.elena.TravelAgency.v5.User.domain.Passport;
import main.java.ru.elena.TravelAgency.v5.common.business.dto.BaseDTO;

import java.util.List;

public abstract class UserDTO extends BaseDTO<Long> {
    private String firstName;
    private String lastName;
    private Passport passport;

    private List<Order> orders;

    public UserDTO() {}

    private Passport createPassport(Passport passport) {
        Passport userPassport = new Passport();
        userPassport.setSeries(passport.getSeries());
        userPassport.setNumber(passport.getSeries());
        return userPassport;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Passport getPassport() {
        return createPassport(passport);
    }

    public void setPassport(String series, String number) {
        this.passport = new Passport(series, number);
    }

    public void setPassport(Passport passport) {
        this.passport = createPassport(passport);
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
