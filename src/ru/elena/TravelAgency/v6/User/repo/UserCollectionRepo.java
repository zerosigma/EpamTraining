package ru.elena.TravelAgency.v6.User.repo;

import ru.elena.TravelAgency.v5.User.domain.User;
import ru.elena.TravelAgency.v5.User.repo.UserRepo;
import ru.elena.TravelAgency.v5.User.search.UserSearchCondition;

import java.util.List;

public interface UserCollectionRepo extends UserRepo {
    List<? extends User> search(UserSearchCondition userSearchCondition);
}
