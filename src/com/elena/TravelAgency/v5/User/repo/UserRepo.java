package com.elena.TravelAgency.v5.User.repo;

import com.elena.TravelAgency.v5.User.domain.Passport;
import com.elena.TravelAgency.v5.User.domain.User;
import com.elena.TravelAgency.v5.common.business.repo.BaseRepo;

public interface UserRepo extends BaseRepo<User, Long> {
    void delete(Passport passport);
    User find(Passport passport);
}
