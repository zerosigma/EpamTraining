package main.java.ru.elena.TravelAgency.v6.City.repo.implementation.memory;

import main.java.ru.elena.TravelAgency.v6.City.domain.City;
import main.java.ru.elena.TravelAgency.v6.City.repo.CityArrayRepo;
import main.java.ru.elena.TravelAgency.v6.City.search.CitySearchCondition;
import main.java.ru.elena.TravelAgency.v6.common.solution.utils.ArrayUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import static main.java.ru.elena.TravelAgency.v6.Storage.GlobalIDGenerator.generateNextValue;
import static main.java.ru.elena.TravelAgency.v6.Storage.Storage.cities;

public class CityMemoryArrayRepo implements CityArrayRepo {
    private static final City[] EMPTY_CITY_ARRAY = new City[0];
    private int cityIndexInStorage = -1;

    @Override
    public City insert(City city) {
        if (cityIndexInStorage == cities.length - 1) {
            City[] newCities = new City[cities.length * 2];
            System.arraycopy(cities, 0, newCities, 0, cities.length);
            cities = newCities;
        }

        cityIndexInStorage++;
        city.setId(generateNextValue());
        cities[cityIndexInStorage] = city;

        return city;
    }

    @Override
    public void insert(Collection<City> cities) {
        cities.forEach(this::insert);
    }

    @Override
    public void deleteByID(Long id) {
        Integer cityIndex = findIndex(id);

        if (cityIndex != null) {
            ArrayUtils.deleteElement(cities, cityIndex);
            cityIndexInStorage--;
        }
    }

    @Override
    public void update(City entity) {

    }

    @Override
    public Optional<City> findByID(Long id) {
        return Arrays.stream(cities).filter(city -> city.getId().equals(id)).findAny();
    }

    @Override
    public Optional<City> find(String name) {
        return Arrays.stream(cities).filter(city -> city.getName().equals(name)).findAny();
    }

    private Integer findIndex(long id) {
        for (int i = 0; i < cities.length; i++)
            if (cities[i].getId().equals(id))
                return i;

         return null;
    }

    @Override
    public City[] search(CitySearchCondition citySearchCondition) {
        if (citySearchCondition.searchById()) {
            Optional<City> foundCity = findByID(citySearchCondition.getId());
            return foundCity.map(city -> new City[]{city}).orElse(EMPTY_CITY_ARRAY);
        }
        else {
            City[] result = new City[cities.length];
            int resultIndex = 0;

            for (City city : cities)
                if (city != null) {
                    boolean found = true;

                    if (citySearchCondition.searchByCityName())
                        found = citySearchCondition.getName().equals(city.getName());

                    if (found) {
                        result[resultIndex] = city;
                        resultIndex++;
                    }
                }

            if (resultIndex > 0) {
                City[] returnableResult = new City[resultIndex];
                System.arraycopy(result, 0, returnableResult, 0, resultIndex);
                return returnableResult;
            }

            return EMPTY_CITY_ARRAY;
        }
    }
}
