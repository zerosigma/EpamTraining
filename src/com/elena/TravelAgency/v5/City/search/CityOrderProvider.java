package com.elena.TravelAgency.v5.City.search;

import com.elena.TravelAgency.v5.City.domain.City;

import java.util.Comparator;
import java.util.List;

public class CityOrderProvider {
    public void applyOrdering(List<City> cities, CitySearchCondition citySearchCondition) {
        Comparator<City> cityComparator = null;

        CityFieldOrder majorField = citySearchCondition.getCityFieldOrder();

        switch (citySearchCondition.getOrderType()) {
            case SIMPLE: {
                cityComparator = CityComparator.getInstance().getComparatorByField(majorField);
                break;
            }

            case COMPLEX: {
                cityComparator = CityComparator.getInstance().getComplexComparator(majorField);
                break;
            }
        }

        switch (citySearchCondition.getOrderDirection()) {
            case ASC: {
                cities.sort(cityComparator);
                break;
            }

            case DESC: {
                cities.sort(cityComparator.reversed());
                break;
            }
        }
    }
}
