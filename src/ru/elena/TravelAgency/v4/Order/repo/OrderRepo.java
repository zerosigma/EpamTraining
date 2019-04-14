package ru.elena.TravelAgency.v4.Order.repo;

import ru.elena.TravelAgency.v4.Order.domain.Order;
import ru.elena.TravelAgency.v4.common.repo.BaseRepo;

public interface OrderRepo extends BaseRepo {
    void add(Order order);
    void delete(Order order);
    Order find(long id);

}
