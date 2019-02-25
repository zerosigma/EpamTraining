package com.elena.TravelAgency.v3.User.service;

import com.elena.TravelAgency.v3.Order.Order;
import com.elena.TravelAgency.v3.Order.repo.OrderMemoryRepo;
import com.elena.TravelAgency.v3.User.User;
import com.elena.TravelAgency.v3.User.repo.UserMemoryRepo;

public class UserMemoryService implements UserService {
    private UserMemoryRepo userMemoryRepo = new UserMemoryRepo();
    private OrderMemoryRepo orderMemoryRepo = new OrderMemoryRepo();

    public void add(User user) {
       userMemoryRepo.add(user);

       if (user.getOrders() != null)
           for (Order order : user.getOrders())
               orderMemoryRepo.add(order);
    }

    public void delete(Long id) {
        userMemoryRepo.delete(id);
    }

    public void delete(User user) {
        userMemoryRepo.delete(user);
    }

    public void delete(User.Passport passport) {
        userMemoryRepo.delete(passport);
    }

    public void find(Long id) {
        userMemoryRepo.find(id);
    }

    public void find(User.Passport passport) {
        userMemoryRepo.find(passport);
    }
}