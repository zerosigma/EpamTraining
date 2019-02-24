package com.elena.TravelAgency.v2.User.repo;

import com.elena.TravelAgency.v2.User.User;

import static com.elena.TravelAgency.v2.Storage.Storage.users;
import static com.elena.TravelAgency.v2.utils.ArrayUtils.ArrayUtils.deleteElement;

public class UserMemoryRepo {
    private int userIndexInStorage = -1;

    public void addUser(User user) {
        if (userIndexInStorage == users.length - 1) {
            User[] newUsers = new User[users.length * 2];
            System.arraycopy(user, 0, newUsers, 0, users.length);
            users = newUsers;
        }

        userIndexInStorage++;
        users[userIndexInStorage] = user;
    }

    public void deleteUser(Long id) {
        Integer userIndex = findIndex(id);

        if (userIndex != null) {
            deleteElement(users, userIndex);
            userIndexInStorage--;
        }
    }

    public void deleteUser(User user) {
        Integer userIndex = findIndex(user);

        if (userIndex != null) {
            deleteElement(users, userIndex);
            userIndexInStorage--;
        }
    }

    public void deleteUser(User.Passport passport) {
        Integer userIndex = findIndex(passport);

        if (userIndex != null) {
            deleteElement(users, userIndex);
            userIndexInStorage--;
        }
    }

    public User findUser(Long id) {
        for (User user : users)
            if (user.getId().equals(id))
                return user;

        return null;
    }

    public User findUser(User.Passport passport) {
        for (User user : users)
            if (user.getPassport().equals(passport))
                return user;

        return null;
    }

    private Integer findIndex(Long id) {
        for (int i = 0; i < users.length; i++)
            if (users[i].getId().equals(id))
                return i;

        return null;
    }

    private Integer findIndex(User.Passport passport) {
        for (int i = 0; i < users.length; i++)
            if (users[i].getPassport().equals(passport))
                return i;

        return null;
    }

    private Integer findIndex(User user) {
        for (int i = 0; i < users.length; i++)
            if (users[i].equals(user))
                return i;

        return null;
    }
}
