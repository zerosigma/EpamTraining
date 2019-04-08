package com.elena.TravelAgency.v5.User.service;

import com.elena.TravelAgency.v5.User.domain.User;
import com.elena.TravelAgency.v5.User.search.UserSearchCondition;

import java.util.List;

public interface UserCollectionService extends UserService {
    List<? extends User> search(UserSearchCondition userSearchCondition);
}
