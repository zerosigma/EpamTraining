package com.elena.TravelAgency.v4.Order.service;

import com.elena.TravelAgency.v4.Order.domain.Order;
import com.elena.TravelAgency.v4.Order.search.OrderSearchCondition;

public interface OrderArrayService extends OrderService {
    Order[] search(OrderSearchCondition orderSearchCondition);
}
