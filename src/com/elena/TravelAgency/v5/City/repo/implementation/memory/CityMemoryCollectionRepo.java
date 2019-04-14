package com.elena.TravelAgency.v5.City.repo.implementation.memory;

import com.elena.TravelAgency.v5.City.domain.City;
import com.elena.TravelAgency.v5.City.repo.CityCollectionRepo;
import com.elena.TravelAgency.v5.City.search.CityOrderProvider;
import com.elena.TravelAgency.v5.City.search.CitySearchCondition;
import com.elena.TravelAgency.v5.Storage.GlobalIDGenerator;
import com.elena.TravelAgency.v5.Storage.SequenceGenerator;
import com.elena.TravelAgency.v5.common.business.search.Paginator;

import java.util.*;

import static com.elena.TravelAgency.v5.Storage.GlobalIDGenerator.generateNextValue;
import static com.elena.TravelAgency.v5.Storage.Storage.citiesList;
import static com.elena.TravelAgency.v5.common.solution.utils.CollectionUtils.nextPageWithData;

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
        City city = findByID(id);

        if (city != null)
            citiesList.remove(city);
    }

    @Override
    public void delete(City city) {
        City cityElem = findByEntity(city);

        if (cityElem != null)
            citiesList.remove(city);
    }

    @Override
    public void update(City entity) {

    }

    @Override
    public City findByID(Long id) {
        return findByIndex(id);
    }

    @Override
    public City find(String name) {
        for (City city : citiesList)
            if (city.getName().equals(name))
                return city;

        return null;
    }

    private City findByIndex(long id) {
        for (City city : citiesList)
            if (Long.valueOf(id).equals(city.getId()))
                return city;

        return null;
    }

    private City findByEntity(City cityToFind) {
        for (City city : citiesList)
            if (city.equals(cityToFind))
                return city;

        return null;
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

    private List<City> getDataByPage(List<City> cities, Paginator paginator) {
        return nextPageWithData(cities, paginator.getOffset(), paginator.getLimit());
    }
}
