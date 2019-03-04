package com.elena.TravelAgency.v4.User.repo;

import com.elena.TravelAgency.v4.User.domain.User;
import com.elena.TravelAgency.v4.User.search.UserSearchCondition;

public interface UserArrayRepo extends UserRepo {
    User[] search(UserSearchCondition userSearchCondition);
}
