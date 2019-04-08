package com.elena.TravelAgency.v5.common.business.service;

import java.util.Collection;

public interface BaseService<TYPE, ID> {
    void deleteByID(ID id);
    void insert(TYPE entity);
    void insert(Collection<TYPE> entities);
    void delete(TYPE entity);
    void update(TYPE entity);
    TYPE findByID(ID id);
}
