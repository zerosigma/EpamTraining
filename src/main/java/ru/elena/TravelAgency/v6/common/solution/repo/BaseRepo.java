package main.java.ru.elena.TravelAgency.v6.common.solution.repo;

import java.util.Collection;
import java.util.Optional;

public interface BaseRepo<TYPE, ID> {
    void deleteByID(ID id);
    TYPE insert(TYPE entity);
    void insert(Collection<TYPE> entities);
    void update(TYPE entity);
    Optional<TYPE> findByID(ID id);
}
