package main.java.ru.elena.TravelAgency.v3.Order.service;

import main.java.ru.elena.TravelAgency.v3.Order.Order;
import main.java.ru.elena.TravelAgency.v3.Order.repo.OrderMemoryRepo;

public class OrderMemoryService implements OrderService {
    private OrderMemoryRepo orderMemoryRepo = new OrderMemoryRepo();

    public void add(Order order) {
        if (order != null)
            orderMemoryRepo.add(order);
    }

    public void delete(Long id) {
        if (id != null)
            orderMemoryRepo.delete(id);
    }

    public void delete(Order order) {
        if (order != null)
            orderMemoryRepo.delete(order);
    }

    public void find(Long id) {
        if (id != null)
            orderMemoryRepo.find(id);
    }
}
