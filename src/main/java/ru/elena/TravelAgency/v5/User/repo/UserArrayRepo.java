package main.java.ru.elena.TravelAgency.v5.User.repo;

import main.java.ru.elena.TravelAgency.v5.User.domain.User;
import main.java.ru.elena.TravelAgency.v5.User.search.UserSearchCondition;

public interface UserArrayRepo extends UserRepo {
    User[] search(UserSearchCondition userSearchCondition);
}
