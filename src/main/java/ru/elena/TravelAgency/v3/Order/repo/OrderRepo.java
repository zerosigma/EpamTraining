package main.java.ru.elena.TravelAgency.v3.Order.repo;

import main.java.ru.elena.TravelAgency.v3.Order.Order;
import main.java.ru.elena.TravelAgency.v3.common.repo.BaseRepo;

public interface OrderRepo extends BaseRepo {
    void add(Order order);
    void delete(Order order);
    Order find(long id);

}
