package main.java.ru.elena.TravelAgency.v4.User.repo;

import main.java.ru.elena.TravelAgency.v4.User.domain.User;
import main.java.ru.elena.TravelAgency.v4.common.repo.BaseRepo;

public interface UserRepo extends BaseRepo {
    void add(User user);
    void delete(User user);
    void delete(User.Passport passport);
    User find(long id);
    User find(User.Passport passport);
}
