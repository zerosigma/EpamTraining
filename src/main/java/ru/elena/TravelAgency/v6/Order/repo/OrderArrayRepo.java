package main.java.ru.elena.TravelAgency.v6.Order.repo;

import main.java.ru.elena.TravelAgency.v5.Order.domain.Order;
import main.java.ru.elena.TravelAgency.v5.Order.repo.OrderRepo;
import main.java.ru.elena.TravelAgency.v5.Order.search.OrderSearchCondition;

public interface OrderArrayRepo extends OrderRepo {
    Order[] search(OrderSearchCondition orderSearchCondition);
}
