package main.java.ru.elena.TravelAgency.v6.Order.repo;

import main.java.ru.elena.TravelAgency.v5.City.domain.City;
import main.java.ru.elena.TravelAgency.v5.Order.domain.Order;
import main.java.ru.elena.TravelAgency.v5.Order.repo.OrderCollectionRepo;
import main.java.ru.elena.TravelAgency.v5.Order.search.OrderSearchCondition;
import main.java.ru.elena.TravelAgency.v5.Storage.Storage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static main.java.ru.elena.TravelAgency.v5.Storage.GlobalIDGenerator.generateNextValue;

public class OrderMemoryCollectionRepo implements OrderCollectionRepo {
    @Override
    public List<Order> search(OrderSearchCondition orderSearchCondition) {
        List<Order> searchResult = searchProcess(orderSearchCondition);

        return searchResult;
    }

    private List<Order> searchProcess(OrderSearchCondition orderSearchCondition) {
        if (orderSearchCondition.searchById())
            return Collections.singletonList(findByIndex(orderSearchCondition.getId()));
        else {
            List<Order> result = new ArrayList<>();

            for (Order order : Storage.ordersList) {
                boolean found = true;

                if (orderSearchCondition.searchByUser())
                    found = orderSearchCondition.getUserID().equals(order.getUser().getId());

                if (found && orderSearchCondition.searchByPrice())
                    found = orderSearchCondition.getPrice().equals(order.getPrice());

                if (found && orderSearchCondition.searchByCity())
                    found = findCityByID(order, orderSearchCondition.getCityID());

                if (found && orderSearchCondition.searchByCountry())
                    found = findCountryByID(order, orderSearchCondition.getCountryID());

                if (found)
                    result.add(order);
            }

            return result;
        }
    }

    private boolean findCityByID(Order order, Long cityId) {
        for (City city : order.getCitiesInOrder())
            if (cityId.equals(city.getId()))
                return true;

        return false;
    }

    private boolean findCountryByID(Order order, Long countryId) {
        for (City city : order.getCitiesInOrder())
            if (countryId.equals(city.getIdCountry()))
                return true;

        return false;
    }

    @Override
    public Order insert(Order order) {
        order.setId(generateNextValue());
        Storage.ordersList.add(order);

        return order;
    }

    @Override
    public void insert(Collection<Order> orders) {
        orders.forEach(this::insert);
    }

    @Override
    public void delete(Order order) {
        Order orderElem = findByEntity(order);

        if (orderElem != null)
            Storage.ordersList.remove(order);

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
            Storage.ordersList.remove(order);

    }

    private Order findByIndex(long id) {
        for (Order order : Storage.ordersList)
            if (Long.valueOf(id).equals(order.getId()))
                return order;

        return null;
    }

    private Order findByEntity(Order cityToFind) {
        for (Order order : Storage.ordersList)
            if (order.equals(cityToFind))
                return order;

        return null;
    }

    @Override
    public int countOrdersWithCity(long cityId) {
        int count = 0;

        for (Order order : Storage.ordersList)
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

        for (Order order : Storage.ordersList)
            for (City city : order.getCitiesInOrder())
                if (city.getIdCountry() == countryId) {
                    count++;
                    break;
                }

        return count;
    }
}
