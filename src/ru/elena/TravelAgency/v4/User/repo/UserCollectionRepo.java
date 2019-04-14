package ru.elena.TravelAgency.v4.User.repo;

import ru.elena.TravelAgency.v4.User.domain.User;
import ru.elena.TravelAgency.v4.User.search.UserSearchCondition;

import java.util.List;

public interface UserCollectionRepo extends UserRepo {
    List<User> search(UserSearchCondition userSearchCondition);
}