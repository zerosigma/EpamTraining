package ru.elena.TravelAgency.v6.Order.repo;

import ru.elena.TravelAgency.v5.Order.domain.Order;
import ru.elena.TravelAgency.v5.common.business.repo.BaseRepo;

public interface OrderRepo extends BaseRepo<Order, Long> {
    int countOrdersWithCity(long cityId);
    int countOrdersWithCountry(long countryId);
}
