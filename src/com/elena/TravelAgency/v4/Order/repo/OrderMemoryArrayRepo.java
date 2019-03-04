package com.elena.TravelAgency.v4.Order.repo;

import com.elena.TravelAgency.v4.Order.domain.Order;
import com.elena.TravelAgency.v4.Order.search.OrderSearchCondition;

import static com.elena.TravelAgency.v4.Storage.Storage.orders;
import static com.elena.TravelAgency.v4.common.utils.ArrayUtils.deleteElement;

public class OrderMemoryArrayRepo implements OrderArrayRepo {
    private static final Order[] EMPTY_ORDER_ARRAY = new Order[0];
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

    @Override
    public Order[] search(OrderSearchCondition orderSearchCondition) {
        if (orderSearchCondition.searchById())
            return new Order[]{find(orderSearchCondition.getId())};
        else {
            Order[] result = new Order[orders.length];
            int resultIndex = 0;

            for (Order order : orders)
                if (order != null) {
                    boolean found = true;

                    if (orderSearchCondition.searchByPrice())
                        found = orderSearchCondition.getPrice().equals(order.getPrice());

                    if (found) {
                        result[resultIndex] = order;
                        resultIndex++;
                    }
                }

            if (resultIndex > 0) {
                Order[] returnableResult = new Order[resultIndex];
                System.arraycopy(result, 0, returnableResult, 0, resultIndex);
                return returnableResult;
            }

            return EMPTY_ORDER_ARRAY;
        }
    }
}
