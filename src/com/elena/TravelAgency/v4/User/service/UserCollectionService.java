package com.elena.TravelAgency.v4.User.service;

import com.elena.TravelAgency.v4.User.domain.User;
import com.elena.TravelAgency.v4.User.search.UserSearchCondition;

import java.util.List;

public interface UserCollectionService extends UserService {
    List<User> search(UserSearchCondition userSearchCondition);
}
