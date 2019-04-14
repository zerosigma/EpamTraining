package ru.elena.TravelAgency.v5.Order.service;

import ru.elena.TravelAgency.v5.Order.domain.Order;
import ru.elena.TravelAgency.v5.Order.search.OrderSearchCondition;

public interface OrderArrayService extends OrderService {
    Order[] search(OrderSearchCondition orderSearchCondition);
}
