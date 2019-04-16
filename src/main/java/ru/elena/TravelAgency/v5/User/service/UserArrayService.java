package main.java.ru.elena.TravelAgency.v5.User.service;

import main.java.ru.elena.TravelAgency.v5.User.domain.User;
import main.java.ru.elena.TravelAgency.v5.User.search.UserSearchCondition;

public interface UserArrayService extends UserService {
    User[] search(UserSearchCondition userSearchCondition);
}
