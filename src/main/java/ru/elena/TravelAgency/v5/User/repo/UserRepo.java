package main.java.ru.elena.TravelAgency.v5.User.repo;

import main.java.ru.elena.TravelAgency.v5.User.domain.Passport;
import main.java.ru.elena.TravelAgency.v5.User.domain.User;
import main.java.ru.elena.TravelAgency.v5.common.business.repo.BaseRepo;

public interface UserRepo extends BaseRepo<User, Long> {
    void delete(Passport passport);
    User find(Passport passport);
}
