package main.java.ru.elena.TravelAgency.v6.User.service.implementation.memory;

import main.java.ru.elena.TravelAgency.v6.User.domain.Passport;
import main.java.ru.elena.TravelAgency.v6.User.domain.User;
import main.java.ru.elena.TravelAgency.v6.User.repo.UserArrayRepo;
import main.java.ru.elena.TravelAgency.v6.User.search.UserSearchCondition;
import main.java.ru.elena.TravelAgency.v6.User.service.UserArrayService;

import java.util.Collection;
import java.util.Optional;

public class UserMemoryArrayService implements UserArrayService {
    private final UserArrayRepo userRepo;

    public UserMemoryArrayService(UserArrayRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User insert(User user) {
        if (user != null)
            userRepo.insert(user);

        return user;
    }

    @Override
    public void insert(Collection<User> users) {
        if (users != null && !users.isEmpty())
            userRepo.insert(users);
    }

    @Override
    public void deleteByID(Long id) {
        if (id != null)
            userRepo.deleteByID(id);
    }

    @Override
    public void delete(User user) {
        if (user.getId() != null)
            deleteByID(user.getId());
    }

    @Override
    public void update(User user) {
        if (user.getId() != null)
            userRepo.update(user);
    }

    @Override
    public void delete(Passport passport) {
        if (passport != null)
            userRepo.delete(passport);
    }

    @Override
    public Optional<User> findByID(Long id) {
        if (id != null)
            userRepo.findByID(id);

        return Optional.empty();
    }

    @Override
    public Optional<User> find(Passport passport) {
        if (passport != null)
            userRepo.find(passport);

        return Optional.empty();
    }

    @Override
    public User[] search(UserSearchCondition userSearchCondition) {
        return userRepo.search(userSearchCondition);
    }
}
