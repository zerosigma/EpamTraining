package com.elena.TravelAgency.v4.Order.repo;

import com.elena.TravelAgency.v4.Order.domain.Order;
import com.elena.TravelAgency.v4.Order.search.OrderSearchCondition;

public interface OrderArrayRepo extends OrderRepo {
    Order[] search(OrderSearchCondition orderSearchCondition);
}
