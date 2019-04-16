package main.java.ru.elena.TravelAgency.v6.Order.service;

import main.java.ru.elena.TravelAgency.v5.Order.domain.Order;
import main.java.ru.elena.TravelAgency.v5.Order.repo.OrderCollectionRepo;
import main.java.ru.elena.TravelAgency.v5.Order.search.OrderSearchCondition;
import main.java.ru.elena.TravelAgency.v5.Order.service.OrderCollectionService;

import java.util.Collection;
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

    public Order insert(Order order) {
        if (order != null)
            orderRepo.insert(order);
        return order;
    }

    @Override
    public void insert(Collection<Order> orders) {
        if (!orders.isEmpty())
            orderRepo.insert(orders);
    }

    public void deleteByID(Long id) {
        if (id != null)
            orderRepo.deleteByID(id);
    }

    public void delete(Order order) {
        if (order != null)
            orderRepo.delete(order);
    }

    @Override
    public void update(Order order) {
        if (order.getId() != null)
            orderRepo.update(order);
    }

    public Order findByID(Long id) {
        if (id != null)
            orderRepo.findByID(id);

        return null;
    }
}
