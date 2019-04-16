package main.java.ru.elena.TravelAgency.v4.User.service;

import main.java.ru.elena.TravelAgency.v4.User.domain.User;
import main.java.ru.elena.TravelAgency.v4.common.service.BaseService;

public interface UserService extends BaseService {
    void add(User user);
    void delete(User user);
    void delete(User.Passport passport);
    User find(Long id);
    User find(User.Passport passport);
}
