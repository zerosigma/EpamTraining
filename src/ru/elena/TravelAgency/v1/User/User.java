package ru.elena.TravelAgency.v1.User;

import ru.elena.TravelAgency.v1.Order.Order;

import java.util.Objects;

public class User {
    private Long id;
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

    public Long getId() {
        return id;
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
