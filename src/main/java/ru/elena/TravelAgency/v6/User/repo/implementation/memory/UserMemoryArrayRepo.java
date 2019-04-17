package main.java.ru.elena.TravelAgency.v6.User.repo.implementation.memory;

import main.java.ru.elena.TravelAgency.v6.User.domain.Passport;
import main.java.ru.elena.TravelAgency.v6.User.domain.User;
import main.java.ru.elena.TravelAgency.v6.User.repo.UserArrayRepo;
import main.java.ru.elena.TravelAgency.v6.User.search.UserSearchCondition;
import main.java.ru.elena.TravelAgency.v6.common.solution.utils.ArrayUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

import static main.java.ru.elena.TravelAgency.v6.Storage.GlobalIDGenerator.generateNextValue;
import static main.java.ru.elena.TravelAgency.v6.Storage.Storage.users;

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
        user.setId(generateNextValue());
        users[userIndexInStorage] = user;

        return user;
    }

    @Override
    public void insert(Collection<User> users) {
        users.forEach(this::insert);
    }

    @Override
    public void deleteByID(Long id) {
        Integer userIndex = findIndex(id);

        if (userIndex != null) {
            ArrayUtils.deleteElement(users, userIndex);
            userIndexInStorage--;
        }
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(Passport passport) {
        Integer userIndex = findIndex(passport);

        if (userIndex != null) {
            ArrayUtils.deleteElement(users, userIndex);
            userIndexInStorage--;
        }
    }

    @Override
    public Optional<User> findByID(Long id) {
        return Arrays.stream(users).filter(user -> user.getId().equals(id)).findAny();
    }

    @Override
    public Optional<User> find(Passport passport) {
        return Arrays.stream(users).filter(user -> user.getPassport().equals(passport)).findAny();
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

    @Override
    public User[] search(UserSearchCondition userSearchCondition) {
        if (userSearchCondition.searchById()) {
            Optional<User> foundUser = findByID(userSearchCondition.getId());
            return foundUser.map(user -> new User[]{user}).orElse(EMPTY_USER_ARRAY);
        }
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
