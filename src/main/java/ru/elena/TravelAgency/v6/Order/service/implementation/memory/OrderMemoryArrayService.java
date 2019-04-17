package main.java.ru.elena.TravelAgency.v6.Order.service.implementation.memory;

import main.java.ru.elena.TravelAgency.v6.Order.domain.Order;
import main.java.ru.elena.TravelAgency.v6.Order.repo.OrderArrayRepo;
import main.java.ru.elena.TravelAgency.v6.Order.search.OrderSearchCondition;
import main.java.ru.elena.TravelAgency.v6.Order.service.OrderArrayService;

import java.util.Collection;
import java.util.Optional;

public class OrderMemoryArrayService implements OrderArrayService {
    private final OrderArrayRepo orderRepo;

    public OrderMemoryArrayService(OrderArrayRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    @Override
    public Order insert(Order order) {
        if (order != null)
            orderRepo.insert(order);

        return order;
    }

    @Override
    public void insert(Collection<Order> orders) {
        if (orders != null && !orders.isEmpty())
            orderRepo.insert(orders);
    }

    public void deleteByID(Long id) {
        if (id != null)
            orderRepo.deleteByID(id);
    }

    public void delete(Order order) {
        if (order != null)
            deleteByID(order.getId());
    }

    @Override
    public void update(Order order) {
        if (order.getId() != null)
            orderRepo.update(order);
    }

    @Override
    public Optional<Order> findByID(Long id) {
        if (id != null)
            orderRepo.findByID(id);

        return Optional.empty();
    }

    @Override
    public Order[] search(OrderSearchCondition orderSearchCondition) {
        return orderRepo.search(orderSearchCondition);
    }
}
