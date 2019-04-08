package com.elena.TravelAgency.v5.User.repo;

import com.elena.TravelAgency.v5.User.domain.User;
import com.elena.TravelAgency.v5.User.search.UserSearchCondition;

public interface UserArrayRepo extends UserRepo {
    User[] search(UserSearchCondition userSearchCondition);
}
