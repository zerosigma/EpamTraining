package main.java.ru.elena.TravelAgency.v4.Order.repo;

import main.java.ru.elena.TravelAgency.v4.Order.domain.Order;
import main.java.ru.elena.TravelAgency.v4.Order.search.OrderSearchCondition;

public interface OrderArrayRepo extends OrderRepo {
    Order[] search(OrderSearchCondition orderSearchCondition);
}
