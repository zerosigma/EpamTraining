package com.elena.TravelAgency.v5.Order.repo;

import com.elena.TravelAgency.v5.Order.domain.Order;
import com.elena.TravelAgency.v5.Order.search.OrderSearchCondition;

import java.util.List;

public interface OrderCollectionRepo extends OrderRepo {
    List<Order> search(OrderSearchCondition orderSearchCondition);
}
