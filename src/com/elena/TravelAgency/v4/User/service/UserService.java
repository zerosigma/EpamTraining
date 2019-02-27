package com.elena.TravelAgency.v4.User.service;

import com.elena.TravelAgency.v4.User.domain.User;
import com.elena.TravelAgency.v4.common.service.BaseService;

public interface UserService extends BaseService {
    void add(User user);
    void delete(User user);
    void delete(User.Passport passport);
    void find(User.Passport passport);
}
