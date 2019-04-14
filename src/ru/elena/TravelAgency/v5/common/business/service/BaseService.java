package ru.elena.TravelAgency.v5.common.business.service;

import ru.elena.TravelAgency.v5.common.business.exception.BaseTravelAgencyCheckedException;

import java.util.Collection;

public interface BaseService<TYPE, ID> {
    void deleteByID(ID id) throws BaseTravelAgencyCheckedException;
    TYPE insert(TYPE entity);
    void insert(Collection<TYPE> entities);
    void delete(TYPE entity) throws BaseTravelAgencyCheckedException;
    void update(TYPE entity);
    TYPE findByID(ID id);
}
