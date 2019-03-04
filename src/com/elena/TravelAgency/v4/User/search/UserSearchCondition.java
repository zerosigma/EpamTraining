package com.elena.TravelAgency.v4.User.search;

import com.elena.TravelAgency.v4.User.domain.User;
import com.elena.TravelAgency.v4.common.search.BaseSearchCondition;

import static com.elena.TravelAgency.v4.common.utils.StringUtils.isNotEmptyString;

public class UserSearchCondition extends BaseSearchCondition {
    private String firstName;
    private String lastName;
    private User.Passport passport;

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

    public User.Passport getPassport() {
        return passport;
    }

    public void setPassport(User.Passport passport) {
        this.passport = passport;
    }

    public boolean searchByFirstName() {
        return isNotEmptyString(firstName);
    }

    public boolean searchByLastName() {
        return isNotEmptyString(lastName);
    }

    public boolean searchByPassport() {
        return passport != null;
    }
}
