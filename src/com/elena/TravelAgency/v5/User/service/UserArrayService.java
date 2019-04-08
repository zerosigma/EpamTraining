package com.elena.TravelAgency.v5.User.service;

import com.elena.TravelAgency.v5.User.domain.User;
import com.elena.TravelAgency.v5.User.search.UserSearchCondition;

public interface UserArrayService extends UserService {
    User[] search(UserSearchCondition userSearchCondition);
}
