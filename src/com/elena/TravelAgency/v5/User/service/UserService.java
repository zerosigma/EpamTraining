package com.elena.TravelAgency.v5.User.service;

import com.elena.TravelAgency.v5.User.domain.Passport;
import com.elena.TravelAgency.v5.User.domain.User;
import com.elena.TravelAgency.v5.common.business.service.BaseService;

public interface UserService extends BaseService<User, Long> {
    void delete(Passport passport);;
    User find(Passport passport);
}
