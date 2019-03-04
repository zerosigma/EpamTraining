package com.elena.TravelAgency.v4.Order.repo;

import com.elena.TravelAgency.v4.Order.domain.Order;
import com.elena.TravelAgency.v4.Order.search.OrderSearchCondition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.elena.TravelAgency.v4.Storage.Storage.ordersList;

public class OrderMemoryCollectionRepo implements OrderCollectionRepo {
    @Override
    public List<Order> search(OrderSearchCondition orderSearchCondition) {
        if (orderSearchCondition.searchById())
            return Collections.singletonList(find(orderSearchCondition.getId()));
        else {
            List<Order> result = new ArrayList<>();

            for (Order order: ordersList) {
                boolean found = true;

                if (orderSearchCondition.searchByPrice())
                    found = orderSearchCondition.getPrice().equals(order.getPrice());

                if (found)
                    result.add(order);
            }

            return Collections.emptyList();
        }
    }

    @Override
    public void add(Order order) {
        if (findByEntity(order) == null)
            ordersList.add(order);
    }

    @Override
    public void delete(Order order) {
        Order orderElem = findByEntity(order);

        if (orderElem != null)
            ordersList.remove(order);

    }

    @Override
    public Order find(long id) {
        return findByIndex(id);
    }

    @Override
    public void delete(long id) {
        Order order = find(id);

        if (order != null)
            ordersList.remove(order);

    }

    private Order findByIndex(long id) {
        for (Order order : ordersList)
            if (Long.valueOf(id).equals(order.getId()))
                return order;

        return null;
    }

    private Order findByEntity(Order cityToFind) {
        for (Order order : ordersList)
            if (order.equals(cityToFind))
                return order;

        return null;
    }
}
