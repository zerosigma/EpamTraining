package main.java.ru.elena.TravelAgency.v3.Order.repo;

import main.java.ru.elena.TravelAgency.v3.Order.Order;

import static main.java.ru.elena.TravelAgency.v3.Storage.Storage.orders;
import static main.java.ru.elena.TravelAgency.v3.common.utils.ArrayUtils.deleteElement;

public class OrderMemoryRepo implements OrderRepo {
    private int orderIndexInStorage = -1;

    public void add(Order order) {
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

    public void delete(long id) {
        Integer orderIndex = findIndex(id);

        if (orderIndex != null) {
            deleteElement(orders, orderIndex);
            orderIndexInStorage--;
        }
    }

    public void delete(Order order) {
        Integer orderIndex = findIndex(order);

        if (orderIndex != null) {
            deleteElement(orders, orderIndex);
            orderIndexInStorage--;
        }
    }

    public Order find(long id) {
        for (Order order : orders)
            if (order.getId().equals(id))
                return order;

        return null;
    }

    private Integer findIndex(long id) {
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
