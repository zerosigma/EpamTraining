package main.java.ru.elena.TravelAgency.v2.User.service;

import main.java.ru.elena.TravelAgency.v2.Order.Order;
import main.java.ru.elena.TravelAgency.v2.Order.repo.OrderMemoryRepo;
import main.java.ru.elena.TravelAgency.v2.User.User;
import main.java.ru.elena.TravelAgency.v2.User.repo.UserMemoryRepo;

public class UserMemoryService {
    private UserMemoryRepo userMemoryRepo = new UserMemoryRepo();
    private OrderMemoryRepo orderMemoryRepo = new OrderMemoryRepo();

    public void addUser(User user) {
       userMemoryRepo.addUser(user);

       if (user.getOrders() != null)
           for (Order order : user.getOrders())
               orderMemoryRepo.addOrder(order);
    }

    public void deleteUser(Long id) {
        userMemoryRepo.deleteUser(id);
    }

    public void deleteUser(User user) {
        userMemoryRepo.deleteUser(user);
    }

    public void deleteUser(User.Passport passport) {
        userMemoryRepo.deleteUser(passport);
    }

    public void findUser(Long id) {
        userMemoryRepo.findUser(id);
    }

    public void findUser(User.Passport passport) {
        userMemoryRepo.findUser(passport);
    }
}
