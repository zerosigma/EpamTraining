package ru.elena.TravelAgency.v5.User.service;

import ru.elena.TravelAgency.v5.User.domain.User;
import ru.elena.TravelAgency.v5.User.search.UserSearchCondition;

import java.util.List;

public interface UserCollectionService extends UserService {
    List<? extends User> search(UserSearchCondition userSearchCondition);
}
