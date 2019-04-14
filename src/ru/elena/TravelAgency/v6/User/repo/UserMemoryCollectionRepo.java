package ru.elena.TravelAgency.v6.User.repo;

import ru.elena.TravelAgency.v5.User.domain.Passport;
import ru.elena.TravelAgency.v5.User.domain.User;
import ru.elena.TravelAgency.v5.User.repo.UserCollectionRepo;
import ru.elena.TravelAgency.v5.User.search.UserSearchCondition;
import ru.elena.TravelAgency.v5.Storage.Storage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static ru.elena.TravelAgency.v5.Storage.GlobalIDGenerator.generateNextValue;

public class UserMemoryCollectionRepo implements UserCollectionRepo {
    @Override
    public List<? extends User> search(UserSearchCondition userSearchCondition) {
        List<? extends User> searchResult = searchProcess(userSearchCondition);

        return searchResult;
    }

    private List<? extends  User> searchProcess(UserSearchCondition userSearchCondition) {
        List<User> result = new ArrayList<>();

        for (User user : Storage.usersList) {
            boolean found = true;

            if (userSearchCondition.searchByFirstName())
                found = userSearchCondition.getFirstName().equals(user.getFirstName());

            if (found && userSearchCondition.searchByLastName())
                found = userSearchCondition.getLastName().equals(user.getLastName());

            if (found && userSearchCondition.searchByPassport())
                found = userSearchCondition.getPassport().equals(user.getPassport());

            if (found) {
                result.add(user);
            }
        }

        return result;
    }

    @Override
    public User insert(User user) {
        user.setId(generateNextValue());
        Storage.usersList.add(user);

        return user;
    }

    @Override
    public void insert(Collection<User> users) {
        users.forEach(this::insert);
    }

    @Override
    public void delete(User user) {
        User userElem = findByEntity(user);

        if (userElem != null)
            Storage.usersList.remove(user);
    }

    @Override
    public void update(User entity) {

    }

    @Override
    public void delete(Passport passport) {
        User user = find(passport);

        if (user != null)
            Storage.usersList.remove(user);
    }

    @Override
    public User findByID(Long id) {
        return findByIndex(id);
    }

    @Override
    public User find(Passport passport) {
        for (User user : Storage.usersList)
            if (user.getPassport().equals(passport))
                return user;

        return null;
    }

    @Override
    public void deleteByID(Long id) {
        User user = findByIndex(id);

        if (user != null)
            Storage.usersList.remove(user);
    }

    private User findByIndex(long id) {
        for (User user : Storage.usersList)
            if (Long.valueOf(id).equals(user.getId()))
                return user;

        return null;
    }

    private User findByEntity(User userToFind) {
        for (User user: Storage.usersList)
            if (user.equals(userToFind))
                return user;

        return null;
    }
}
