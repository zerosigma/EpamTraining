package ru.elena.TravelAgency.v5.User.repo;

import ru.elena.TravelAgency.v5.User.domain.Passport;
import ru.elena.TravelAgency.v5.User.domain.User;
import ru.elena.TravelAgency.v5.common.business.repo.BaseRepo;

public interface UserRepo extends BaseRepo<User, Long> {
    void delete(Passport passport);
    User find(Passport passport);
}
