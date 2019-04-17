package main.java.ru.elena.TravelAgency.v6.User.repo.implementation.memory;

import main.java.ru.elena.TravelAgency.v6.User.domain.Passport;
import main.java.ru.elena.TravelAgency.v6.User.domain.User;
import main.java.ru.elena.TravelAgency.v6.User.repo.UserCollectionRepo;
import main.java.ru.elena.TravelAgency.v6.User.search.UserSearchCondition;

import java.util.*;

import static main.java.ru.elena.TravelAgency.v6.Storage.GlobalIDGenerator.generateNextValue;
import static main.java.ru.elena.TravelAgency.v6.Storage.Storage.usersList;

public class UserMemoryCollectionRepo implements UserCollectionRepo {
    @Override
    public List<? extends User> search(UserSearchCondition userSearchCondition) {
        List<? extends User> searchResult = searchProcess(userSearchCondition);

        return searchResult;
    }

    private List<? extends  User> searchProcess(UserSearchCondition userSearchCondition) {
        if (userSearchCondition.searchById()) {
            Optional<User> foundUser = findByIndex(userSearchCondition.getId());
            return foundUser.map(Collections::singletonList).orElse(Collections.emptyList());
        }
        else {
            List<User> result = new ArrayList<>();

            for (User user : usersList) {
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
    }

    @Override
    public User insert(User user) {
        user.setId(generateNextValue());
        usersList.add(user);

        return user;
    }

    @Override
    public void insert(Collection<User> users) {
        users.forEach(this::insert);
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(Passport passport) {
        Optional<User> foundUser = find(passport);
        foundUser.map(user -> usersList.remove(user));
    }

    @Override
    public Optional<User> findByID(Long id) {
        return findByIndex(id);
    }

    @Override
    public Optional<User> find(Passport passport) {
        return usersList.stream().filter(user -> user.getPassport().equals(passport)).findAny();
    }

    @Override
    public void deleteByID(Long id) {
        Optional<User> foundUser = findByIndex(id);
        foundUser.map(user -> usersList.remove(user));
    }

    private Optional<User> findByIndex(long id) {
        return usersList.stream().filter(user -> Long.valueOf(id).equals(user.getId())).findAny();
    }
}
