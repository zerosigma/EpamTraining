package main.java.ru.elena.TravelAgency.v6.User.domain;

import main.java.ru.elena.TravelAgency.v5.User.domain.Passport;
import main.java.ru.elena.TravelAgency.v5.User.domain.User;

public class UserWithSocialBenefits extends User {
    public UserWithSocialBenefits(String firstName, String lastName, Passport passport) {
        super(firstName, lastName, passport);
    }
}
