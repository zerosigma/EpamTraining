package com.elena.TravelAgency.v4.User.repo;

import com.elena.TravelAgency.v4.User.domain.User;
import com.elena.TravelAgency.v4.User.search.UserSearchCondition;

import java.util.List;

public interface UserCollectionRepo extends UserRepo {
    List<User> search(UserSearchCondition userSearchCondition);
}
