package main.java.ru.elena.TravelAgency.v6.City.repo.implementation.memory;


import main.java.ru.elena.TravelAgency.v6.City.domain.City;
import main.java.ru.elena.TravelAgency.v6.City.repo.CityCollectionRepo;
import main.java.ru.elena.TravelAgency.v6.City.search.CityOrderProvider;
import main.java.ru.elena.TravelAgency.v6.City.search.CitySearchCondition;
import main.java.ru.elena.TravelAgency.v6.common.business.search.Paginator;
import main.java.ru.elena.TravelAgency.v6.common.solution.utils.CollectionUtils;

import java.util.*;

import static main.java.ru.elena.TravelAgency.v6.Storage.GlobalIDGenerator.generateNextValue;
import static main.java.ru.elena.TravelAgency.v6.Storage.Storage.citiesList;

public class CityMemoryCollectionRepo implements CityCollectionRepo {
    private CityOrderProvider cityOrderProvider = new CityOrderProvider();

    @Override
    public City insert(City city) {
        city.setId(generateNextValue());
        citiesList.add(city);

        return city;
    }

    @Override
    public void insert(Collection<City> cities) {
        cities.forEach(this::insert);
    }

    @Override
    public void deleteByID(Long id) {
        Optional<City> foundCity = findByID(id);
        foundCity.map(city -> citiesList.remove(city));
    }

    @Override
    public void update(City entity) {

    }

    @Override
    public Optional<City> findByID(Long id) {
        return findByIndex(id);
    }

    @Override
    public Optional<City> find(String name) {
        return citiesList.stream().filter(city -> city.getName().equals(name)).findAny();
    }

    private Optional<City> findByIndex(long id) {
        return citiesList.stream().filter(city -> Long.valueOf(id).equals(city.getId())).findAny();
    }

    @Override
    public List<City> search(CitySearchCondition citySearchCondition) {
        List<City> searchResult = searchProcess(citySearchCondition);

        boolean needApplyOrder = !searchResult.isEmpty() && citySearchCondition.needOrdering();
        if (needApplyOrder)
            cityOrderProvider.applyOrdering(searchResult, citySearchCondition);

        if (!searchResult.isEmpty() && citySearchCondition.needPaginate())
            searchResult = getDataByPage(searchResult, citySearchCondition.getPaginator());

        return searchResult;
    }

    private List<City> searchProcess(CitySearchCondition citySearchCondition) {
        if (citySearchCondition.searchById()) {
            Optional<City> foundCity = findByIndex(citySearchCondition.getId());
            return foundCity.map(Collections::singletonList).orElse(Collections.emptyList());
        }
        else {
            List<City> result = new ArrayList<>();

            for (City city : citiesList) {
                boolean found = true;

                if (citySearchCondition.searchByCityName())
                    found = citySearchCondition.getName().equals(city.getName());

                if (found && citySearchCondition.searchByClimateType())
                    found = citySearchCondition.getClimateType().name().equals(city.getClimateType().name());

                if (found)
                    result.add(city);
            }

            return result;
        }
    }

    private List<City> getDataByPage(List<City> cities, Paginator paginator) {
        return CollectionUtils.nextPageWithData(cities, paginator.getOffset(), paginator.getLimit());
    }
}
