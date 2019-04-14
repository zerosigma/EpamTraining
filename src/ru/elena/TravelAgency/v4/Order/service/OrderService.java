package ru.elena.TravelAgency.v4.Order.service;

import ru.elena.TravelAgency.v4.Order.domain.Order;
import ru.elena.TravelAgency.v4.common.service.BaseService;

public interface OrderService extends BaseService {
    void add(Order order);
    void delete(Order order);
    Order find(Long id);
}
