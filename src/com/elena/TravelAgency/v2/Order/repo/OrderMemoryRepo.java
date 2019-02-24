package com.elena.TravelAgency.v2.Order.repo;

import com.elena.TravelAgency.v2.Order.Order;

import static com.elena.TravelAgency.v2.Storage.Storage.orders;
import static com.elena.TravelAgency.v2.utils.ArrayUtils.ArrayUtils.deleteElement;

public class OrderMemoryRepo {
    private int orderIndexInStorage = -1;

    public void addOrder(Order order) {
        if (findIndex(order) == null) {
            if (orderIndexInStorage == orders.length - 1) {
                Order[] newOrders = new Order[orders.length * 2];
                System.arraycopy(orders, 0, newOrders, 0, orders.length);
                orders = newOrders;
            }

            orderIndexInStorage++;
            orders[orderIndexInStorage] = order;
        }
    }

    public void deleteOrder(Long id) {
        Integer orderIndex = findIndex(id);

        if (orderIndex != null) {
            deleteElement(orders, orderIndex);
            orderIndexInStorage--;
        }
    }

    public void deleteOrder(Order order) {
        Integer orderIndex = findIndex(order);

        if (orderIndex != null) {
            deleteElement(orders, orderIndex);
            orderIndexInStorage--;
        }
    }

    public Order findOrder(Long id) {
        for (Order order : orders)
            if (order.getId().equals(id))
                return order;

        return null;
    }

    private Integer findIndex(Long id) {
        for (int i = 0; i < orders.length; i++)
            if (orders[i].getId().equals(id))
                return i;

        return null;
    }

    private Integer findIndex(Order order) {
        for (int i = 0; i < orders.length; i++)
            if (orders[i].equals(order))
                return i;

        return null;
    }
}
