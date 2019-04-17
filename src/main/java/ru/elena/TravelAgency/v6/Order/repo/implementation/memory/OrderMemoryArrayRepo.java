package main.java.ru.elena.TravelAgency.v6.Order.repo.implementation.memory;

import main.java.ru.elena.TravelAgency.v6.City.domain.City;
import main.java.ru.elena.TravelAgency.v6.Order.domain.Order;
import main.java.ru.elena.TravelAgency.v6.Order.repo.OrderArrayRepo;
import main.java.ru.elena.TravelAgency.v6.Order.search.OrderSearchCondition;
import main.java.ru.elena.TravelAgency.v6.common.solution.utils.ArrayUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import static main.java.ru.elena.TravelAgency.v6.Storage.Storage.orders;

public class OrderMemoryArrayRepo implements OrderArrayRepo {
    private static final Order[] EMPTY_ORDER_ARRAY = new Order[0];
    private int orderIndexInStorage = -1;

    public Order insert(Order order) {
        if (orderIndexInStorage == orders.length - 1) {
            Order[] newOrders = new Order[orders.length * 2];
            System.arraycopy(orders, 0, newOrders, 0, orders.length);
            orders = newOrders;
        }

        orderIndexInStorage++;
        orders[orderIndexInStorage] = order;

        return order;
    }

    public void deleteByID(Long id) {
        Integer orderIndex = findIndex(id);

        if (orderIndex != null) {
            ArrayUtils.deleteElement(orders, orderIndex);
            orderIndexInStorage--;
        }
    }

    @Override
    public void insert(Collection<Order> orders) {
        orders.forEach(this::insert);
    }

    @Override
    public void update(Order entity) {

    }

    @Override
    public Optional<Order> findByID(Long id) {
        return Arrays.stream(orders).filter(order -> order.getId().equals(id)).findAny();
    }

    private Integer findIndex(long id) {
        for (int i = 0; i < orders.length; i++)
            if (orders[i].getId().equals(id))
                return i;

        return null;
    }

    @Override
    public Order[] search(OrderSearchCondition orderSearchCondition) {
        if (orderSearchCondition.searchById()) {
            Optional<Order> foundOrder = findByID(orderSearchCondition.getId());
            return foundOrder.map(order -> new Order[]{order}).orElse(EMPTY_ORDER_ARRAY);
        }
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

    @Override
    public int countOrdersWithCity(long cityId) {
        int count = 0;

        for (Order order : orders)
            if (order != null)
                for (City city : order.getCitiesInOrder())
                    if (city.getId() == cityId) {
                        count++;
                        break;
                    }

        return count;
    }

    @Override
    public int countOrdersWithCountry(long countryId) {
        int count = 0;

        for (Order order : orders)
            if (order != null)
                for (City city : order.getCitiesInOrder())
                    if (city.getIdCountry() == countryId) {
                        count++;
                        break;
                    }

        return count;
    }
}
