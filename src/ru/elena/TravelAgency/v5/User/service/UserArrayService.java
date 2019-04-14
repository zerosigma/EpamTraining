package ru.elena.TravelAgency.v5.User.service;

import ru.elena.TravelAgency.v5.User.domain.User;
import ru.elena.TravelAgency.v5.User.search.UserSearchCondition;

public interface UserArrayService extends UserService {
    User[] search(UserSearchCondition userSearchCondition);
}
