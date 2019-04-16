package main.java.ru.elena.TravelAgency.v5.Order.repo;

import main.java.ru.elena.TravelAgency.v5.City.domain.City;
import main.java.ru.elena.TravelAgency.v5.Order.domain.Order;
import main.java.ru.elena.TravelAgency.v5.Order.search.OrderSearchCondition;

import java.util.Collection;

import static main.java.ru.elena.TravelAgency.v5.Storage.Storage.orders;
import static main.java.ru.elena.TravelAgency.v5.common.solution.utils.ArrayUtils.deleteElement;

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
            deleteElement(orders, orderIndex);
            orderIndexInStorage--;
        }
    }

    @Override
    public void insert(Collection<Order> orders) {
        orders.forEach(this::insert);
    }

    public void delete(Order order) {
        Integer orderIndex = findIndex(order);

        if (orderIndex != null) {
            deleteElement(orders, orderIndex);
            orderIndexInStorage--;
        }
    }

    @Override
    public void update(Order entity) {

    }

    public Order findByID(Long id) {
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
            return new Order[]{findByID(orderSearchCondition.getId())};
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
