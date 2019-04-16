package main.java.ru.elena.TravelAgency.v4.User.service;

import main.java.ru.elena.TravelAgency.v4.User.domain.User;
import main.java.ru.elena.TravelAgency.v4.User.search.UserSearchCondition;

public interface UserArrayService extends UserService {
    User[] search(UserSearchCondition userSearchCondition);
}
