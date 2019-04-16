package main.java.ru.elena.TravelAgency.v0;

import java.util.ArrayList;

public class User {
    private String name;
    private String surname;
    private Passport passport;

    private ArrayList<Order> orders;

    public User(String name, String surname, Passport passport) {
        this.name = name;
        this.surname = surname;
        this.passport = passport;
        this.orders = new ArrayList<>();
    }
}
