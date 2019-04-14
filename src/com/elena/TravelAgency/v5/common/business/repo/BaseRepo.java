package com.elena.TravelAgency.v5.common.business.repo;

import java.util.Collection;

public interface BaseRepo<TYPE, ID> {
    void deleteByID(ID id);
    TYPE insert(TYPE entity);
    void insert(Collection<TYPE> entities);
    void delete(TYPE entity);
    void update(TYPE entity);
    TYPE findByID(ID id);
}
