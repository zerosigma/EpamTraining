package com.elena.TravelAgency.v5.Order.service;

import com.elena.TravelAgency.v5.Order.domain.Order;
import com.elena.TravelAgency.v5.Order.repo.OrderArrayRepo;
import com.elena.TravelAgency.v5.Order.search.OrderSearchCondition;

import java.util.Collection;

public class OrderMemoryArrayService implements OrderArrayService {
    private final OrderArrayRepo orderRepo;

    public OrderMemoryArrayService(OrderArrayRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    public void insert(Order order) {
        if (order != null)
            orderRepo.insert(order);
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

    @Override
    public Order[] search(OrderSearchCondition orderSearchCondition) {
        return orderRepo.search(orderSearchCondition);
    }
}