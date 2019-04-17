package main.java.ru.elena.TravelAgency.v6.User.service;

import main.java.ru.elena.TravelAgency.v6.User.domain.Passport;
import main.java.ru.elena.TravelAgency.v6.User.domain.User;
import main.java.ru.elena.TravelAgency.v6.common.solution.service.BaseService;

import java.util.Optional;

public interface UserService extends BaseService<User, Long> {
    void delete(Passport passport);;
    Optional<User> find(Passport passport);
}
