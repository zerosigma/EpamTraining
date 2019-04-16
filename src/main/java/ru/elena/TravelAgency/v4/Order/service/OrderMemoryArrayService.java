package main.java.ru.elena.TravelAgency.v4.Order.service;

import main.java.ru.elena.TravelAgency.v4.Order.domain.Order;
import main.java.ru.elena.TravelAgency.v4.Order.repo.OrderArrayRepo;
import main.java.ru.elena.TravelAgency.v4.Order.search.OrderSearchCondition;

public class OrderMemoryArrayService implements OrderArrayService {
    private final OrderArrayRepo orderRepo;

    public OrderMemoryArrayService(OrderArrayRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    public void add(Order order) {
        if (order != null)
            orderRepo.add(order);
    }

    public void delete(Long id) {
        if (id != null)
            orderRepo.delete(id);
    }

    public void delete(Order order) {
        if (order != null)
            orderRepo.delete(order);
    }

    public Order find(Long id) {
        if (id != null)
            orderRepo.find(id);

        return null;
    }

    @Override
    public Order[] search(OrderSearchCondition orderSearchCondition) {
        return orderRepo.search(orderSearchCondition);
    }
}
