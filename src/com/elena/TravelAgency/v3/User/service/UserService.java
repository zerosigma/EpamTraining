package com.elena.TravelAgency.v3.User.service;

import com.elena.TravelAgency.v3.User.User;
import com.elena.TravelAgency.v3.common.service.BaseService;

public interface UserService extends BaseService {
    void add(User user);
    void delete(User user);
    void delete(User.Passport passport);
    void find(User.Passport passport);
}
