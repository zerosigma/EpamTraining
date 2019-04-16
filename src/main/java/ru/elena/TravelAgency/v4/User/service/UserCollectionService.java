package main.java.ru.elena.TravelAgency.v4.User.service;

import main.java.ru.elena.TravelAgency.v4.User.domain.User;
import main.java.ru.elena.TravelAgency.v4.User.search.UserSearchCondition;

import java.util.List;

public interface UserCollectionService extends UserService {
    List<User> search(UserSearchCondition userSearchCondition);
}
