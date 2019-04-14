package ru.elena.TravelAgency.v1.Order.service;

import ru.elena.TravelAgency.v1.Order.Order;
import ru.elena.TravelAgency.v1.Order.repo.OrderMemoryRepo;

public class OrderMemoryService {
    private OrderMemoryRepo orderMemoryRepo = new OrderMemoryRepo();

    public void addOrder(Order order) {
        orderMemoryRepo.addOrder(order);
    }

    public void deleteOrder(Long id) {
        orderMemoryRepo.deleteOrder(id);
    }

    public void deleteOrder(Order order) {
        orderMemoryRepo.deleteOrder(order);
    }

    public void findOrder(Long id) {
        orderMemoryRepo.findOrder(id);
    }
}
