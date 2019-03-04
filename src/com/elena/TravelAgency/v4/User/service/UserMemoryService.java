package com.elena.TravelAgency.v4.User.service;

import com.elena.TravelAgency.v4.Order.domain.Order;
import com.elena.TravelAgency.v4.Order.repo.OrderRepo;
import com.elena.TravelAgency.v4.User.domain.User;
import com.elena.TravelAgency.v4.User.repo.UserRepo;

public class UserMemoryService implements UserService {
    private final UserRepo userRepo;
    private final OrderRepo orderRepo;

    public void add(User user) {
        if (user != null) {
            userRepo.add(user);

            if (user.getOrders() != null)
                for (Order order : user.getOrders())
                    orderRepo.add(order);
        }
    }

    public void delete(Long id) {
        if (id != null)
            userRepo.delete(id);
    }

    public void delete(User user) {
        if (user != null)
            userRepo.delete(user);
    }

    public void delete(User.Passport passport) {
        if (passport != null)
            userRepo.delete(passport);
    }

    public void find(Long id) {
        if (id != null)
            userRepo.find(id);
    }

    public void find(User.Passport passport) {
        if (passport != null)
            userRepo.find(passport);
    }
}
