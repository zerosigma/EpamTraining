package ru.elena.TravelAgency.v4.User.service;

import ru.elena.TravelAgency.v4.User.domain.User;
import ru.elena.TravelAgency.v4.common.service.BaseService;

public interface UserService extends BaseService {
    void add(User user);
    void delete(User user);
    void delete(User.Passport passport);
    User find(Long id);
    User find(User.Passport passport);
}
