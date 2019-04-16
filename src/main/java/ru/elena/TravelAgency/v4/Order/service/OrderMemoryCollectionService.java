package main.java.ru.elena.TravelAgency.v4.Order.service;

import main.java.ru.elena.TravelAgency.v4.Order.domain.Order;
import main.java.ru.elena.TravelAgency.v4.Order.repo.OrderCollectionRepo;
import main.java.ru.elena.TravelAgency.v4.Order.search.OrderSearchCondition;

import java.util.List;

public class OrderMemoryCollectionService implements OrderCollectionService {
    private final OrderCollectionRepo orderRepo;

    public OrderMemoryCollectionService(OrderCollectionRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    @Override
    public List<Order> search(OrderSearchCondition orderSearchCondition) {
        return orderRepo.search(orderSearchCondition);
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
}
