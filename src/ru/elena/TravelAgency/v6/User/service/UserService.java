package ru.elena.TravelAgency.v6.User.service;

import ru.elena.TravelAgency.v5.User.domain.Passport;
import ru.elena.TravelAgency.v5.User.domain.User;
import ru.elena.TravelAgency.v5.common.business.service.BaseService;

public interface UserService extends BaseService<User, Long> {
    void delete(Passport passport);;
    User find(Passport passport);
}
