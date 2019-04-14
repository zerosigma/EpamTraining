package ru.elena.TravelAgency.v6.User.repo;

import ru.elena.TravelAgency.v5.User.domain.Passport;
import ru.elena.TravelAgency.v5.User.domain.User;
import ru.elena.TravelAgency.v5.User.repo.UserArrayRepo;
import ru.elena.TravelAgency.v5.User.search.UserSearchCondition;

import java.util.Collection;

import static ru.elena.TravelAgency.v5.Storage.Storage.users;
import static ru.elena.TravelAgency.v5.common.solution.utils.ArrayUtils.deleteElement;

public class UserMemoryArrayRepo implements UserArrayRepo {
    private static final User[] EMPTY_USER_ARRAY = new User[0];
    private int userIndexInStorage = -1;

    public User insert(User user) {
        if (userIndexInStorage == users.length - 1) {
            User[] newUsers = new User[users.length * 2];
            System.arraycopy(users, 0, newUsers, 0, users.length);
            users = newUsers;
        }

        userIndexInStorage++;
        users[userIndexInStorage] = user;

        return user;
    }

    @Override
    public void insert(Collection<User> users) {
        users.forEach(this::insert);
    }

    public void deleteByID(Long id) {
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

    @Override
    public void update(User entity) {

    }

    public void delete(Passport passport) {
        Integer userIndex = findIndex(passport);

        if (userIndex != null) {
            deleteElement(users, userIndex);
            userIndexInStorage--;
        }
    }

    public User findByID(Long id) {
        for (User user : users)
            if (user.getId().equals(id))
                return user;

        return null;
    }

    public User find(Passport passport) {
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

    private Integer findIndex(Passport passport) {
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
            return new User[]{findByID(userSearchCondition.getId())};
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
