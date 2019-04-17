package main.java.ru.elena.TravelAgency.v6.Order.service.implementation.memory;

import main.java.ru.elena.TravelAgency.v6.Order.domain.Order;
import main.java.ru.elena.TravelAgency.v6.Order.repo.OrderCollectionRepo;
import main.java.ru.elena.TravelAgency.v6.Order.search.OrderSearchCondition;
import main.java.ru.elena.TravelAgency.v6.Order.service.OrderCollectionService;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class OrderMemoryCollectionService implements OrderCollectionService {
    private final OrderCollectionRepo orderRepo;

    public OrderMemoryCollectionService(OrderCollectionRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    @Override
    public List<Order> search(OrderSearchCondition orderSearchCondition) {
        return orderRepo.search(orderSearchCondition);
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

    @Override
    public void update(Order order) {
        if (order.getId() != null)
            orderRepo.update(order);
    }

    @Override
    public void deleteByID(Long id) {
        if (id != null)
            orderRepo.deleteByID(id);
    }

    @Override
    public void delete(Order order) {
        if (order != null)
            deleteByID(order.getId());
    }

    @Override
    public Optional<Order> findByID(Long id) {
        if (id != null)
            orderRepo.findByID(id);

        return Optional.empty();
    }
}
