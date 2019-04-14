package ru.elena.TravelAgency.v4.Order.repo;

import ru.elena.TravelAgency.v4.Order.domain.Order;
import ru.elena.TravelAgency.v4.Order.search.OrderSearchCondition;

public interface OrderArrayRepo extends OrderRepo {
    Order[] search(OrderSearchCondition orderSearchCondition);
}
