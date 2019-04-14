package ru.elena.TravelAgency.v5.Order.service;

import ru.elena.TravelAgency.v5.Order.domain.Order;
import ru.elena.TravelAgency.v5.Order.search.OrderSearchCondition;

import java.util.List;

public interface OrderCollectionService extends OrderService {
    List<Order> search(OrderSearchCondition orderSearchCondition);
}
