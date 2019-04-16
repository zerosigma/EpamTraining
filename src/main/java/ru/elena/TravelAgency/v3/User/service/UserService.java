package main.java.ru.elena.TravelAgency.v3.User.service;

import main.java.ru.elena.TravelAgency.v3.User.User;
import main.java.ru.elena.TravelAgency.v3.common.service.BaseService;

public interface UserService extends BaseService {
    void add(User user);
    void delete(User user);
    void delete(User.Passport passport);
    void find(User.Passport passport);
}
