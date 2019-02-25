package com.elena.TravelAgency.v3.Order.service;

import com.elena.TravelAgency.v3.Order.Order;
import com.elena.TravelAgency.v3.common.service.BaseService;

public interface OrderService extends BaseService {
    void add(Order order);
    void delete(Order order);
}
