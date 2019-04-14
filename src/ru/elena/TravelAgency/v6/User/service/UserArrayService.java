package ru.elena.TravelAgency.v6.User.service;

import ru.elena.TravelAgency.v5.User.domain.User;
import ru.elena.TravelAgency.v5.User.search.UserSearchCondition;
import ru.elena.TravelAgency.v5.User.service.UserService;

public interface UserArrayService extends UserService {
    User[] search(UserSearchCondition userSearchCondition);
}
