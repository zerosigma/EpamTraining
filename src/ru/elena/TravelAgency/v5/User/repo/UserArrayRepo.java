package ru.elena.TravelAgency.v5.User.repo;

import ru.elena.TravelAgency.v5.User.domain.User;
import ru.elena.TravelAgency.v5.User.search.UserSearchCondition;

public interface UserArrayRepo extends UserRepo {
    User[] search(UserSearchCondition userSearchCondition);
}
