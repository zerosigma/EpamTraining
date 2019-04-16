package main.java.ru.elena.TravelAgency.v3.User.repo;

import main.java.ru.elena.TravelAgency.v3.User.User;
import main.java.ru.elena.TravelAgency.v3.common.repo.BaseRepo;

public interface UserRepo extends BaseRepo {
    void add(User user);
    void delete(User user);
    void delete(User.Passport passport);
    User find(long id);
    User find(User.Passport passport);
}
