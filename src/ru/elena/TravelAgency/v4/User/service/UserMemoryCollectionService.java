package ru.elena.TravelAgency.v4.User.service;

import ru.elena.TravelAgency.v4.Order.domain.Order;
import ru.elena.TravelAgency.v4.Order.repo.OrderCollectionRepo;
import ru.elena.TravelAgency.v4.User.domain.User;
import ru.elena.TravelAgency.v4.User.repo.UserCollectionRepo;
import ru.elena.TravelAgency.v4.User.search.UserSearchCondition;

import java.util.List;

public class UserMemoryCollectionService implements UserCollectionService {
    private final UserCollectionRepo userRepo;
    private final OrderCollectionRepo orderRepo;

    public UserMemoryCollectionService(UserCollectionRepo userRepo, OrderCollectionRepo orderRepo) {
        this.userRepo = userRepo;
        this.orderRepo = orderRepo;
    }

    @Override
    public List<User> search(UserSearchCondition userSearchCondition) {
        return userRepo.search(userSearchCondition);
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
}
