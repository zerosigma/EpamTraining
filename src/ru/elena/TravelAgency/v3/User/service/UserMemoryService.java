package ru.elena.TravelAgency.v3.User.service;

import ru.elena.TravelAgency.v3.Order.Order;
import ru.elena.TravelAgency.v3.Order.repo.OrderMemoryRepo;
import ru.elena.TravelAgency.v3.User.User;
import ru.elena.TravelAgency.v3.User.repo.UserMemoryRepo;

public class UserMemoryService implements UserService {
    private UserMemoryRepo userMemoryRepo = new UserMemoryRepo();
    private OrderMemoryRepo orderMemoryRepo = new OrderMemoryRepo();

    public void add(User user) {
        if (user != null) {
            userMemoryRepo.add(user);

            if (user.getOrders() != null)
                for (Order order : user.getOrders())
                    orderMemoryRepo.add(order);
        }
    }

    public void delete(Long id) {
        if (id != null)
            userMemoryRepo.delete(id);
    }

    public void delete(User user) {
        if (user != null)
            userMemoryRepo.delete(user);
    }

    public void delete(User.Passport passport) {
        if (passport != null)
            userMemoryRepo.delete(passport);
    }

    public void find(Long id) {
        if (id != null)
            userMemoryRepo.find(id);
    }

    public void find(User.Passport passport) {
        if (passport != null)
            userMemoryRepo.find(passport);
    }
}
