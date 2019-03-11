package com.elena.TravelAgency.v4.User.service;

import com.elena.TravelAgency.v4.User.domain.User;
import com.elena.TravelAgency.v4.User.search.UserSearchCondition;

public interface UserArrayService extends UserService {
    User[] search(UserSearchCondition userSearchCondition);
}
