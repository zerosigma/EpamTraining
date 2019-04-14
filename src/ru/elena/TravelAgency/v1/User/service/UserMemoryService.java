package ru.elena.TravelAgency.v1.User.service;

import ru.elena.TravelAgency.v1.User.User;
import ru.elena.TravelAgency.v1.User.repo.UserMemoryRepo;

public class UserMemoryService {
    private UserMemoryRepo userMemoryRepo = new UserMemoryRepo();

    public void addUser(User user) {
        userMemoryRepo.addUser(user);
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
