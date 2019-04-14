package ru.elena.TravelAgency.v4.User.domain;

import ru.elena.TravelAgency.v4.Order.domain.Order;
import ru.elena.TravelAgency.v4.common.domain.BaseDomain;

import java.util.Arrays;
import java.util.Objects;

public class User extends BaseDomain {
    private String firstName;
    private String lastName;
    private Passport passport;

    private Order[] orders;

    public User(String firstName, String lastName, Passport passport) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.passport = passport;
    }

    public User(Long id, String firstName, String lastName, Passport passport) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.passport = passport;
    }

    // Inner class for representing passport data
    public static class Passport {
        private String series;
        private String number;

        public Passport(String series, String number) {
            this.series = series;
            this.number = number;
        }

        @Override
        public String toString() {
            return series + " " + number;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Passport passport = (Passport) o;
            return series.equals(passport.series) &&
                   number.equals(passport.number);
        }

        @Override
        public int hashCode() {
            return Objects.hash(series, number);
        }
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
        return passport;
    }

    public void setPassport(String series, String number) {
        this.passport.series = series;
        this.passport.number = number;
    }

    public Order[] getOrders() {
        return orders;
    }

    public void setOrders(Order[] orders) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        User user = (User) o;
        return id.equals(user.id) &&
                firstName.equals(user.firstName) &&
                lastName.equals(user.lastName) &&
                passport.equals(user.passport) &&
                Arrays.equals(orders, user.orders);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, firstName, lastName, passport);
        result = 31 * result + Arrays.hashCode(orders);
        return result;
    }
}
