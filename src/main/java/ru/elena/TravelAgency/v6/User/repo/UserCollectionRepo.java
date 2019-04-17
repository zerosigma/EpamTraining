package main.java.ru.elena.TravelAgency.v6.User.repo;

import main.java.ru.elena.TravelAgency.v6.User.domain.User;
import main.java.ru.elena.TravelAgency.v6.User.search.UserSearchCondition;

import java.util.List;

public interface UserCollectionRepo extends UserRepo {
    List<? extends User> search(UserSearchCondition userSearchCondition);
}
