package com.elena.TravelAgency.v3.Order.service;

import com.elena.TravelAgency.v3.Order.Order;
import com.elena.TravelAgency.v3.Order.repo.OrderMemoryRepo;

public class OrderMemoryService implements OrderService {
    private OrderMemoryRepo orderMemoryRepo = new OrderMemoryRepo();

    public void add(Order order) {
        orderMemoryRepo.add(order);
    }

    public void delete(Long id) {
        orderMemoryRepo.delete(id);
    }

    public void delete(Order order) {
        orderMemoryRepo.delete(order);
    }

    public void find(Long id) {
        orderMemoryRepo.find(id);
    }
}
