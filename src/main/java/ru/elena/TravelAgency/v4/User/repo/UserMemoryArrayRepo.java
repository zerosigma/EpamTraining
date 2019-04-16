package main.java.ru.elena.TravelAgency.v4.User.repo;

import main.java.ru.elena.TravelAgency.v4.User.domain.User;
import main.java.ru.elena.TravelAgency.v4.User.search.UserSearchCondition;

import static main.java.ru.elena.TravelAgency.v4.Storage.Storage.users;
import static main.java.ru.elena.TravelAgency.v4.common.utils.ArrayUtils.deleteElement;

public class UserMemoryArrayRepo implements UserArrayRepo {
    private static final User[] EMPTY_USER_ARRAY = new User[0];
    private int userIndexInStorage = -1;

    public void add(User user) {
        if (findIndex(user) == null) {
            if (userIndexInStorage == users.length - 1) {
                User[] newUsers = new User[users.length * 2];
                System.arraycopy(users, 0, newUsers, 0, users.length);
                users = newUsers;
            }

            userIndexInStorage++;
            users[userIndexInStorage] = user;
        }
    }

    public void delete(long id) {
        Integer userIndex = findIndex(id);

        if (userIndex != null) {
            deleteElement(users, userIndex);
            userIndexInStorage--;
        }
    }

    public void delete(User user) {
        Integer userIndex = findIndex(user);

        if (userIndex != null) {
            deleteElement(users, userIndex);
            userIndexInStorage--;
        }
    }

    public void delete(User.Passport passport) {
        Integer userIndex = findIndex(passport);

        if (userIndex != null) {
            deleteElement(users, userIndex);
            userIndexInStorage--;
        }
    }

    public User find(long id) {
        for (User user : users)
            if (user.getId().equals(id))
                return user;

        return null;
    }

    public User find(User.Passport passport) {
        for (User user : users)
            if (user.getPassport().equals(passport))
                return user;

        return null;
    }

    private Integer findIndex(long id) {
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

    @Override
    public User[] search(UserSearchCondition userSearchCondition) {
        if (userSearchCondition.searchById())
            return new User[]{find(userSearchCondition.getId())};
        else {
            User[] result = new User[users.length];
            int resultIndex = 0;

            for (User user : users)
                if (user != null) {
                    boolean found = true;

                    if (userSearchCondition.searchByFirstName())
                        found = userSearchCondition.getFirstName().equals(user.getFirstName());

                    if (found && userSearchCondition.searchByLastName())
                        found = userSearchCondition.getLastName().equals(user.getLastName());

                    if (found && userSearchCondition.searchByPassport())
                        found = userSearchCondition.getPassport().equals(user.getPassport());

                    if (found) {
                        result[resultIndex] = user;
                        resultIndex++;
                    }
                }

            if (resultIndex > 0) {
                User[] returnableResult = new User[resultIndex];
                System.arraycopy(result, 0, returnableResult, 0, resultIndex);
                return returnableResult;
            }

            return EMPTY_USER_ARRAY;
        }
    }
}
