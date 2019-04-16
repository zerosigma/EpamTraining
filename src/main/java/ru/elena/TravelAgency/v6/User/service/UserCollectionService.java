package main.java.ru.elena.TravelAgency.v6.User.service;

import main.java.ru.elena.TravelAgency.v5.User.domain.User;
import main.java.ru.elena.TravelAgency.v5.User.search.UserSearchCondition;
import main.java.ru.elena.TravelAgency.v5.User.service.UserService;

import java.util.List;

public interface UserCollectionService extends UserService {
    List<? extends User> search(UserSearchCondition userSearchCondition);
}