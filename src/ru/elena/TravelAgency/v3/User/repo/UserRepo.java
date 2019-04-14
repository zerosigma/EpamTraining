package ru.elena.TravelAgency.v3.User.repo;

import ru.elena.TravelAgency.v3.User.User;
import ru.elena.TravelAgency.v3.common.repo.BaseRepo;

public interface UserRepo extends BaseRepo {
    void add(User user);
    void delete(User user);
    void delete(User.Passport passport);
    User find(long id);
    User find(User.Passport passport);
}
