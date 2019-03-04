package com.elena.TravelAgency.v4.User.repo;

import com.elena.TravelAgency.v4.User.domain.User;
import com.elena.TravelAgency.v4.User.search.UserSearchCondition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.elena.TravelAgency.v4.Storage.Storage.usersList;

public class UserMemoryCollectionRepo implements UserCollectionRepo {
    @Override
    public List<User> search(UserSearchCondition userSearchCondition) {
        if (userSearchCondition.searchById())
            return Collections.singletonList(find(userSearchCondition.getId()));
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
    public void add(User user) {
        if (findByEntity(user) == null)
            usersList.add(user);
    }

    @Override
    public void delete(User user) {
        User userElem = findByEntity(user);

        if (userElem != null)
            usersList.remove(user);
    }

    @Override
    public void delete(User.Passport passport) {
        User user = find(passport);

        if (user != null)
            usersList.remove(user);
    }

    @Override
    public User find(long id) {
        return findByIndex(id);
    }

    @Override
    public User find(User.Passport passport) {
        for (User user : usersList)
            if (user.getPassport().equals(passport))
                return user;

        return null;
    }

    @Override
    public void delete(long id) {
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
