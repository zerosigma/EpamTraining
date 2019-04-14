package ru.elena.TravelAgency.v4.User.repo;

import ru.elena.TravelAgency.v4.User.domain.User;
import ru.elena.TravelAgency.v4.User.search.UserSearchCondition;

public interface UserArrayRepo extends UserRepo {
    User[] search(UserSearchCondition userSearchCondition);
}
