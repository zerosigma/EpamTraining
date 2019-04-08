package com.elena.TravelAgency.v5.User.service;

import com.elena.TravelAgency.v5.Order.domain.Order;
import com.elena.TravelAgency.v5.Order.repo.OrderCollectionRepo;
import com.elena.TravelAgency.v5.User.domain.Passport;
import com.elena.TravelAgency.v5.User.domain.User;
import com.elena.TravelAgency.v5.User.repo.UserCollectionRepo;
import com.elena.TravelAgency.v5.User.search.UserSearchCondition;

import java.util.Collection;
import java.util.List;

public class UserMemoryCollectionService implements UserCollectionService {
    private final UserCollectionRepo userRepo;
    private final OrderCollectionRepo orderRepo;

    public UserMemoryCollectionService(UserCollectionRepo userRepo, OrderCollectionRepo orderRepo) {
        this.userRepo = userRepo;
        this.orderRepo = orderRepo;
    }

    @Override
    public List<? extends User> search(UserSearchCondition userSearchCondition) {
        return userRepo.search(userSearchCondition);
    }

    public void insert(User user) {
        if (user != null) {
            userRepo.insert(user);

            if (user.getOrders() != null)
                for (Order order : user.getOrders()) {
                    order.setUser(user);
                    orderRepo.insert(order);
                }
        }
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
}
