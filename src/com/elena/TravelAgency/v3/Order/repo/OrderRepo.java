package com.elena.TravelAgency.v3.Order.repo;

import com.elena.TravelAgency.v3.Order.Order;
import com.elena.TravelAgency.v3.common.repo.BaseRepo;

public interface OrderRepo extends BaseRepo {
    void add(Order order);
    void delete(Order order);
    Order find(Long id);

}
