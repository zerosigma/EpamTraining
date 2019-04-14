package ru.elena.TravelAgency.v6.User.domain;

import ru.elena.TravelAgency.v5.Order.domain.Order;
import ru.elena.TravelAgency.v5.User.domain.Passport;
import ru.elena.TravelAgency.v5.common.business.domain.BaseDomain;

import java.util.List;

public abstract class User extends BaseDomain<Long> {
    private String firstName;
    private String lastName;
    private Passport passport;

    private List<Order> orders;

    public User() {}

    public User(String firstName, String lastName, String series, String number) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.passport = new Passport(series, number);
    }

    public User(String firstName, String lastName, Passport passport) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.passport = createPassport(passport);
    }

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

    @Override
    public String toString() {
        return "User " +
                "id = " + id +
                ", firstName: " + firstName +
                ", lastName: " + lastName +
                ", passport: " + passport +
                "\nOrders:\n" + getOrdersAsString();
    }

    private String getOrdersAsString() {
        StringBuilder ordersAsString = new StringBuilder();
        for (Order order : orders)
            ordersAsString.append(order.toString()).append("\n");

        return ordersAsString.toString();
    }
}
