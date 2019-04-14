package ru.elena.TravelAgency.v4.Order.service;

import ru.elena.TravelAgency.v4.Order.domain.Order;
import ru.elena.TravelAgency.v4.Order.search.OrderSearchCondition;

public interface OrderArrayService extends OrderService {
    Order[] search(OrderSearchCondition orderSearchCondition);
}
