package main.java.ru.elena.TravelAgency.v4.User.repo;

import main.java.ru.elena.TravelAgency.v4.User.domain.User;
import main.java.ru.elena.TravelAgency.v4.User.search.UserSearchCondition;

public interface UserArrayRepo extends UserRepo {
    User[] search(UserSearchCondition userSearchCondition);
}
