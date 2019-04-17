package main.java.ru.elena.TravelAgency.v6.User.repo;

import main.java.ru.elena.TravelAgency.v6.User.domain.Passport;
import main.java.ru.elena.TravelAgency.v6.User.domain.User;
import main.java.ru.elena.TravelAgency.v6.common.solution.repo.BaseRepo;

import java.util.Optional;

public interface UserRepo extends BaseRepo<User, Long> {
    void delete(Passport passport);
    Optional<User> find(Passport passport);
}
