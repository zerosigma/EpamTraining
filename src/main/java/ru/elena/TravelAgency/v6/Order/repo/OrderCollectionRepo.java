package main.java.ru.elena.TravelAgency.v6.Order.repo;

import main.java.ru.elena.TravelAgency.v5.Order.domain.Order;
import main.java.ru.elena.TravelAgency.v5.Order.repo.OrderRepo;
import main.java.ru.elena.TravelAgency.v5.Order.search.OrderSearchCondition;

import java.util.List;

public interface OrderCollectionRepo extends OrderRepo {
    List<Order> search(OrderSearchCondition orderSearchCondition);
}
