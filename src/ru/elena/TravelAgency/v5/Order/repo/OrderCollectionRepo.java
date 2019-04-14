package ru.elena.TravelAgency.v5.Order.repo;

import ru.elena.TravelAgency.v5.Order.domain.Order;
import ru.elena.TravelAgency.v5.Order.search.OrderSearchCondition;

import java.util.List;

public interface OrderCollectionRepo extends OrderRepo {
    List<Order> search(OrderSearchCondition orderSearchCondition);
}
