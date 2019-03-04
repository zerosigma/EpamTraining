package com.elena.TravelAgency.v4.Order.service;

import com.elena.TravelAgency.v4.Order.domain.Order;
import com.elena.TravelAgency.v4.Order.repo.OrderRepo;

public class OrderMemoryService implements OrderService {
    private final OrderRepo orderRepo;

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

    public void find(Long id) {
        if (id != null)
            orderRepo.find(id);
    }
}
