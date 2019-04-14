package ru.elena.TravelAgency.v5.Order.repo;

import ru.elena.TravelAgency.v5.Order.domain.Order;
import ru.elena.TravelAgency.v5.Order.search.OrderSearchCondition;

public interface OrderArrayRepo extends OrderRepo {
    Order[] search(OrderSearchCondition orderSearchCondition);
}
