package main.java.ru.elena.TravelAgency.v4.Order.repo;

import main.java.ru.elena.TravelAgency.v4.Order.domain.Order;
import main.java.ru.elena.TravelAgency.v4.Order.search.OrderSearchCondition;

import java.util.List;

public interface OrderCollectionRepo extends OrderRepo {
    List<Order> search(OrderSearchCondition orderSearchCondition);
}
