package main.java.ru.elena.TravelAgency.v6.common.solution.service;

import main.java.ru.elena.TravelAgency.v6.common.business.exception.BaseTravelAgencyCheckedException;

import java.util.Collection;
import java.util.Optional;

public interface BaseService<TYPE, ID> {
    void deleteByID(ID id) throws BaseTravelAgencyCheckedException;
    TYPE insert(TYPE entity);
    void insert(Collection<TYPE> entities);
    void delete(TYPE entity) throws BaseTravelAgencyCheckedException;
    void update(TYPE entity);
    Optional<TYPE> findByID(ID id);
}
