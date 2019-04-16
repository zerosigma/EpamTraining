package main.java.ru.elena.TravelAgency.v6.User.repo;

import main.java.ru.elena.TravelAgency.v5.User.domain.Passport;
import main.java.ru.elena.TravelAgency.v5.User.domain.User;
import main.java.ru.elena.TravelAgency.v5.User.repo.UserArrayRepo;
import main.java.ru.elena.TravelAgency.v5.User.search.UserSearchCondition;
import main.java.ru.elena.TravelAgency.v5.Storage.Storage;
import main.java.ru.elena.TravelAgency.v5.common.solution.utils.ArrayUtils;

import java.util.Collection;

public class UserMemoryArrayRepo implements UserArrayRepo {
    private static final User[] EMPTY_USER_ARRAY = new User[0];
    private int userIndexInStorage = -1;

    public User insert(User user) {
        if (userIndexInStorage == Storage.users.length - 1) {
            User[] newUsers = new User[Storage.users.length * 2];
            System.arraycopy(Storage.users, 0, newUsers, 0, Storage.users.length);
            Storage.users = newUsers;
        }

        userIndexInStorage++;
        Storage.users[userIndexInStorage] = user;

        return user;
    }

    @Override
    public void insert(Collection<User> users) {
        users.forEach(this::insert);
    }

    public void deleteByID(Long id) {
        Integer userIndex = findIndex(id);

        if (userIndex != null) {
            ArrayUtils.deleteElement(Storage.users, userIndex);
            userIndexInStorage--;
        }
    }

    public void delete(User user) {
        Integer userIndex = findIndex(user);

        if (userIndex != null) {
            ArrayUtils.deleteElement(Storage.users, userIndex);
            userIndexInStorage--;
        }
    }

    @Override
    public void update(User entity) {

    }

    public void delete(Passport passport) {
        Integer userIndex = findIndex(passport);

        if (userIndex != null) {
            ArrayUtils.deleteElement(Storage.users, userIndex);
            userIndexInStorage--;
        }
    }

    public User findByID(Long id) {
        for (User user : Storage.users)
            if (user.getId().equals(id))
                return user;

        return null;
    }

    public User find(Passport passport) {
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

    private Integer findIndex(Passport passport) {
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

    @Override
    public User[] search(UserSearchCondition userSearchCondition) {
        if (userSearchCondition.searchById())
            return new User[]{findByID(userSearchCondition.getId())};
        else {
            User[] result = new User[Storage.users.length];
            int resultIndex = 0;

            for (User user : Storage.users)
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
