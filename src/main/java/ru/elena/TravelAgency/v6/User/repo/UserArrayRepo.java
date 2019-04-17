package main.java.ru.elena.TravelAgency.v6.User.repo;

import main.java.ru.elena.TravelAgency.v6.User.domain.User;
import main.java.ru.elena.TravelAgency.v6.User.search.UserSearchCondition;

public interface UserArrayRepo extends UserRepo {
    User[] search(UserSearchCondition userSearchCondition);
}
