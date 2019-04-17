package main.java.ru.elena.TravelAgency.v6.Order.repo.implementation.memory;

import com.sun.org.apache.xpath.internal.operations.Or;
import main.java.ru.elena.TravelAgency.v6.City.domain.City;
import main.java.ru.elena.TravelAgency.v6.Order.domain.Order;
import main.java.ru.elena.TravelAgency.v6.Order.repo.OrderCollectionRepo;
import main.java.ru.elena.TravelAgency.v6.Order.search.OrderSearchCondition;

import java.util.*;

import static main.java.ru.elena.TravelAgency.v6.Storage.GlobalIDGenerator.generateNextValue;
import static main.java.ru.elena.TravelAgency.v6.Storage.Storage.countriesList;
import static main.java.ru.elena.TravelAgency.v6.Storage.Storage.ordersList;

public class OrderMemoryCollectionRepo implements OrderCollectionRepo {
    @Override
    public List<Order> search(OrderSearchCondition orderSearchCondition) {
        List<Order> searchResult = searchProcess(orderSearchCondition);

        return searchResult;
    }

    private List<Order> searchProcess(OrderSearchCondition orderSearchCondition) {
        if (orderSearchCondition.searchById()) {
            Optional<Order> foundOrder = findByIndex(orderSearchCondition.getId());
            return foundOrder.map(Collections::singletonList).orElse(Collections.emptyList());
        }
        else {
            List<Order> result = new ArrayList<>();

            for (Order order : ordersList) {
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
        return order.getCitiesInOrder().stream().anyMatch(city -> cityId.equals(city.getId()));
    }

    private boolean findCountryByID(Order order, Long countryId) {
        return order.getCitiesInOrder().stream().anyMatch(city -> countryId.equals(city.getIdCountry()));
    }

    @Override
    public Order insert(Order order) {
        order.setId(generateNextValue());
        ordersList.add(order);

        return order;
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
        return findByIndex(id);
    }

    @Override
    public void deleteByID(Long id) {
        Optional<Order> foundOrder = findByID(id);
        foundOrder.map(order -> ordersList.remove(order));
    }

    private Optional<Order> findByIndex(long id) {
        return ordersList.stream().filter(order -> Long.valueOf(id).equals(order.getId())).findAny();
    }

    @Override
    public int countOrdersWithCity(long cityId) {
        int count = 0;

        for (Order order : ordersList)
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

        for (Order order : ordersList)
            for (City city : order.getCitiesInOrder())
                if (city.getIdCountry() == countryId) {
                    count++;
                    break;
                }

        return count;
    }
}
