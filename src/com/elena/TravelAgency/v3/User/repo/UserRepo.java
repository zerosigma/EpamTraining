package com.elena.TravelAgency.v3.User.repo;

import com.elena.TravelAgency.v3.User.User;
import com.elena.TravelAgency.v3.common.repo.BaseRepo;

public interface UserRepo extends BaseRepo {
    void add(User user);
    void delete(User user);
    void delete(User.Passport passport);
    User find(Long id);
    User find(User.Passport passport);
}
