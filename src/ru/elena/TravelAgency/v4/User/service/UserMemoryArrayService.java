package ru.elena.TravelAgency.v4.User.service;

import ru.elena.TravelAgency.v4.Order.domain.Order;
import ru.elena.TravelAgency.v4.Order.repo.OrderArrayRepo;
import ru.elena.TravelAgency.v4.User.domain.User;
import ru.elena.TravelAgency.v4.User.repo.UserArrayRepo;
import ru.elena.TravelAgency.v4.User.search.UserSearchCondition;

public class UserMemoryArrayService implements UserArrayService {
    private final UserArrayRepo userRepo;
    private final OrderArrayRepo orderRepo;

    public UserMemoryArrayService(UserArrayRepo userRepo, OrderArrayRepo orderRepo) {
        this.userRepo = userRepo;
        this.orderRepo = orderRepo;
    }

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

    public User find(Long id) {
        if (id != null)
            userRepo.find(id);

        return null;
    }

    public User find(User.Passport passport) {
        if (passport != null)
            userRepo.find(passport);

        return null;
    }

    @Override
    public User[] search(UserSearchCondition userSearchCondition) {
        return userRepo.search(userSearchCondition);
    }
}
