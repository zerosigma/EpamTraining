package ru.elena.TravelAgency.v2.Order.repo;

import ru.elena.TravelAgency.v2.Order.Order;
import ru.elena.TravelAgency.v2.Storage.Storage;

import static ru.elena.TravelAgency.v2.utils.ArrayUtils.ArrayUtils.deleteElement;

public class OrderMemoryRepo {
    private int orderIndexInStorage = -1;

    public void addOrder(Order order) {
        if (findIndex(order) == null) {
            if (orderIndexInStorage == Storage.orders.length - 1) {
                Order[] newOrders = new Order[Storage.orders.length * 2];
                System.arraycopy(Storage.orders, 0, newOrders, 0, Storage.orders.length);
                Storage.orders = newOrders;
            }

            orderIndexInStorage++;
            Storage.orders[orderIndexInStorage] = order;
        }
    }

    public void deleteOrder(Long id) {
        Integer orderIndex = findIndex(id);

        if (orderIndex != null) {
            deleteElement(Storage.orders, orderIndex);
            orderIndexInStorage--;
        }
    }

    public void deleteOrder(Order order) {
        Integer orderIndex = findIndex(order);

        if (orderIndex != null) {
            deleteElement(Storage.orders, orderIndex);
            orderIndexInStorage--;
        }
    }

    public Order findOrder(Long id) {
        for (Order order : Storage.orders)
            if (order.getId().equals(id))
                return order;

        return null;
    }

    private Integer findIndex(Long id) {
        for (int i = 0; i < Storage.orders.length; i++)
            if (Storage.orders[i].getId().equals(id))
                return i;

        return null;
    }

    private Integer findIndex(Order order) {
        for (int i = 0; i < Storage.orders.length; i++)
            if (Storage.orders[i].equals(order))
                return i;

        return null;
    }
}
