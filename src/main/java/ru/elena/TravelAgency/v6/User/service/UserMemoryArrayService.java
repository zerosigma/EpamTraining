package main.java.ru.elena.TravelAgency.v6.User.service;

import main.java.ru.elena.TravelAgency.v5.Order.domain.Order;
import main.java.ru.elena.TravelAgency.v5.Order.repo.OrderArrayRepo;
import main.java.ru.elena.TravelAgency.v5.User.domain.Passport;
import main.java.ru.elena.TravelAgency.v5.User.domain.User;
import main.java.ru.elena.TravelAgency.v5.User.repo.UserArrayRepo;
import main.java.ru.elena.TravelAgency.v5.User.search.UserSearchCondition;
import main.java.ru.elena.TravelAgency.v5.User.service.UserArrayService;

import java.util.Collection;

public class UserMemoryArrayService implements UserArrayService {
    private final UserArrayRepo userRepo;
    private final OrderArrayRepo orderRepo;

    public UserMemoryArrayService(UserArrayRepo userRepo, OrderArrayRepo orderRepo) {
        this.userRepo = userRepo;
        this.orderRepo = orderRepo;
    }

    public User insert(User user) {
        if (user != null) {
            userRepo.insert(user);

            if (user.getOrders() != null)
                for (Order order : user.getOrders()) {
                    order.setUser(user);
                    orderRepo.insert(order);
                }
        }

        return user;
    }

    @Override
    public void insert(Collection<User> users) {
        if (!users.isEmpty())
            userRepo.insert(users);
    }

    public void deleteByID(Long id) {
        if (id != null)
            userRepo.deleteByID(id);
    }

    public void delete(User user) {
        if (user != null)
            userRepo.delete(user);
    }

    @Override
    public void update(User user) {
        if (user.getId() != null)
            userRepo.update(user);
    }

    public void delete(Passport passport) {
        if (passport != null)
            userRepo.delete(passport);
    }

    public User findByID(Long id) {
        if (id != null)
            userRepo.findByID(id);

        return null;
    }

    public User find(Passport passport) {
        if (passport != null)
            userRepo.find(passport);

        return null;
    }

    @Override
    public User[] search(UserSearchCondition userSearchCondition) {
        return userRepo.search(userSearchCondition);
    }
}
