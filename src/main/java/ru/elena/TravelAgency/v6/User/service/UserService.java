package main.java.ru.elena.TravelAgency.v6.User.service;

import main.java.ru.elena.TravelAgency.v5.User.domain.Passport;
import main.java.ru.elena.TravelAgency.v5.User.domain.User;
import main.java.ru.elena.TravelAgency.v5.common.business.service.BaseService;

public interface UserService extends BaseService<User, Long> {
    void delete(Passport passport);;
    User find(Passport passport);
}
