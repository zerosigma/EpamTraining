package main.java.ru.elena.TravelAgency.v5.User.search;

import main.java.ru.elena.TravelAgency.v5.User.domain.Passport;
import main.java.ru.elena.TravelAgency.v5.common.business.search.BaseSearchCondition;

import static main.java.ru.elena.TravelAgency.v4.common.utils.StringUtils.isNotEmptyString;

public class UserSearchCondition extends BaseSearchCondition<Long> {
    private String firstName;
    private String lastName;
    private Passport passport;

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

    public void setPassport(Passport passport) {
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
