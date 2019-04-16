package main.java.ru.elena.TravelAgency.v4.Order.service;

import main.java.ru.elena.TravelAgency.v4.Order.domain.Order;
import main.java.ru.elena.TravelAgency.v4.Order.search.OrderSearchCondition;

public interface OrderArrayService extends OrderService {
    Order[] search(OrderSearchCondition orderSearchCondition);
}
