package com.elena.TravelAgency.v5.User.repo;

import com.elena.TravelAgency.v5.User.domain.User;
import com.elena.TravelAgency.v5.User.search.UserSearchCondition;

import java.util.List;

public interface UserCollectionRepo extends UserRepo {
    List<? extends User> search(UserSearchCondition userSearchCondition);
}
