package ru.elena.TravelAgency.v4.User.service;

import ru.elena.TravelAgency.v4.User.domain.User;
import ru.elena.TravelAgency.v4.User.search.UserSearchCondition;

import java.util.List;

public interface UserCollectionService extends UserService {
    List<User> search(UserSearchCondition userSearchCondition);
}
