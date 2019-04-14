package ru.elena.TravelAgency.v6.User.domain;

import ru.elena.TravelAgency.v5.User.domain.Passport;
import ru.elena.TravelAgency.v5.User.domain.User;

public class VIPUser extends User {
    public VIPUser(String firstName, String lastName, Passport passport) {
        super(firstName, lastName, passport);
    }
}
