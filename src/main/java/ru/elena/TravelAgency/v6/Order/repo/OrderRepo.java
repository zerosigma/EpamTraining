package main.java.ru.elena.TravelAgency.v6.Order.repo;

import main.java.ru.elena.TravelAgency.v6.Order.domain.Order;
import main.java.ru.elena.TravelAgency.v6.common.solution.repo.BaseRepo;

public interface OrderRepo extends BaseRepo<Order, Long> {
    int countOrdersWithCity(long cityId);
    int countOrdersWithCountry(long countryId);
}
