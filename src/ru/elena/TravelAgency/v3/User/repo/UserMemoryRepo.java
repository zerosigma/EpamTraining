package ru.elena.TravelAgency.v3.User.repo;

import ru.elena.TravelAgency.v3.User.User;
import ru.elena.TravelAgency.v3.Storage.Storage;

import static ru.elena.TravelAgency.v3.common.utils.ArrayUtils.deleteElement;

public class UserMemoryRepo implements UserRepo {
    private int userIndexInStorage = -1;

    public void add(User user) {
        if (findIndex(user) == null) {
            if (userIndexInStorage == Storage.users.length - 1) {
                User[] newUsers = new User[Storage.users.length * 2];
                System.arraycopy(Storage.users, 0, newUsers, 0, Storage.users.length);
                Storage.users = newUsers;
            }

            userIndexInStorage++;
            Storage.users[userIndexInStorage] = user;
        }
    }

    public void delete(long id) {
        Integer userIndex = findIndex(id);

        if (userIndex != null) {
            deleteElement(Storage.users, userIndex);
            userIndexInStorage--;
        }
    }

    public void delete(User user) {
        Integer userIndex = findIndex(user);

        if (userIndex != null) {
            deleteElement(Storage.users, userIndex);
            userIndexInStorage--;
        }
    }

    public void delete(User.Passport passport) {
        Integer userIndex = findIndex(passport);

        if (userIndex != null) {
            deleteElement(Storage.users, userIndex);
            userIndexInStorage--;
        }
    }

    public User find(long id) {
        for (User user : Storage.users)
            if (user.getId().equals(id))
                return user;

        return null;
    }

    public User find(User.Passport passport) {
        for (User user : Storage.users)
            if (user.getPassport().equals(passport))
                return user;

        return null;
    }

    private Integer findIndex(long id) {
        for (int i = 0; i < Storage.users.length; i++)
            if (Storage.users[i].getId().equals(id))
                return i;

        return null;
    }

    private Integer findIndex(User.Passport passport) {
        for (int i = 0; i < Storage.users.length; i++)
            if (Storage.users[i].getPassport().equals(passport))
                return i;

        return null;
    }

    private Integer findIndex(User user) {
        for (int i = 0; i < Storage.users.length; i++)
            if (Storage.users[i].equals(user))
                return i;

        return null;
    }
}
