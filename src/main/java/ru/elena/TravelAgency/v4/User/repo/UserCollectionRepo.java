package main.java.ru.elena.TravelAgency.v4.User.repo;

import main.java.ru.elena.TravelAgency.v4.User.domain.User;
import main.java.ru.elena.TravelAgency.v4.User.search.UserSearchCondition;

import java.util.List;

public interface UserCollectionRepo extends UserRepo {
    List<User> search(UserSearchCondition userSearchCondition);
}
