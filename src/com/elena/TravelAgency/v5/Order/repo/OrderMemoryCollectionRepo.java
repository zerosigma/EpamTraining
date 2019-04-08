package com.elena.TravelAgency.v5.Order.repo;

import com.elena.TravelAgency.v5.Order.domain.Order;
import com.elena.TravelAgency.v5.Order.search.OrderSearchCondition;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static com.elena.TravelAgency.v5.Storage.GlobalIDGenerator.generateNextValue;
import static com.elena.TravelAgency.v5.Storage.Storage.ordersList;

public class OrderMemoryCollectionRepo implements OrderCollectionRepo {
    @Override
    public List<Order> search(OrderSearchCondition orderSearchCondition) {
        if (orderSearchCondition.searchById())
            return Collections.singletonList(findByID(orderSearchCondition.getId()));
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
    public void insert(Order order) {
        order.setId(generateNextValue());
        ordersList.add(order);
    }

    @Override
    public void insert(Collection<Order> orders) {
        orders.forEach(this::insert);
    }

    @Override
    public void delete(Order order) {
        Order orderElem = findByEntity(order);

        if (orderElem != null)
            ordersList.remove(order);

    }

    @Override
    public void update(Order entity) {

    }

    @Override
    public Order findByID(Long id) {
        return findByIndex(id);
    }

    @Override
    public void deleteByID(Long id) {
        Order order = findByID(id);

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
