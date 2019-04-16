package main.java.ru.elena.TravelAgency.v4.Order.service;

import main.java.ru.elena.TravelAgency.v4.Order.domain.Order;
import main.java.ru.elena.TravelAgency.v4.Order.search.OrderSearchCondition;

import java.util.List;

public interface OrderCollectionService extends OrderService {
    List<Order> search(OrderSearchCondition orderSearchCondition);
}
