package com.elena.TravelAgency.v5.Order.repo;

import com.elena.TravelAgency.v5.Order.domain.Order;
import com.elena.TravelAgency.v5.Order.search.OrderSearchCondition;

public interface OrderArrayRepo extends OrderRepo {
    Order[] search(OrderSearchCondition orderSearchCondition);
}
