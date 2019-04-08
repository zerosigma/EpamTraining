package com.elena.TravelAgency.v5.User.repo;

import com.elena.TravelAgency.v5.User.domain.Passport;
import com.elena.TravelAgency.v5.User.domain.User;
import com.elena.TravelAgency.v5.User.search.UserSearchCondition;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static com.elena.TravelAgency.v5.Storage.GlobalIDGenerator.generateNextValue;
import static com.elena.TravelAgency.v5.Storage.Storage.usersList;

public class UserMemoryCollectionRepo implements UserCollectionRepo {
    @Override
    public List<? extends User> search(UserSearchCondition userSearchCondition) {
        if (userSearchCondition.searchById())
            return Collections.singletonList(findByID(userSearchCondition.getId()));
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

            return Collections.emptyList();
        }
    }

    @Override
    public void insert(User user) {
        user.setId(generateNextValue());
        usersList.add(user);
    }

    @Override
    public void insert(Collection<User> users) {
        users.forEach(this::insert);
    }

    @Override
    public void delete(User user) {
        User userElem = findByEntity(user);

        if (userElem != null)
            usersList.remove(user);
    }

    @Override
    public void update(User entity) {

    }

    @Override
    public void delete(Passport passport) {
        User user = find(passport);

        if (user != null)
            usersList.remove(user);
    }

    @Override
    public User findByID(Long id) {
        return findByIndex(id);
    }

    @Override
    public User find(Passport passport) {
        for (User user : usersList)
            if (user.getPassport().equals(passport))
                return user;

        return null;
    }

    @Override
    public void deleteByID(Long id) {
        User user = findByIndex(id);

        if (user != null)
            usersList.remove(user);
    }

    private User findByIndex(long id) {
        for (User user : usersList)
            if (Long.valueOf(id).equals(user.getId()))
                return user;

        return null;
    }

    private User findByEntity(User userToFind) {
        for (User user: usersList)
            if (user.equals(userToFind))
                return user;

        return null;
    }
}
