package main.java.ru.elena.TravelAgency.v6.City.search;

import main.java.ru.elena.TravelAgency.v6.City.domain.City;
import main.java.ru.elena.TravelAgency.v6.common.business.search.OrderDirection;
import main.java.ru.elena.TravelAgency.v6.common.business.search.OrderType;

import java.util.Comparator;
import java.util.List;

public class CityOrderProvider {
    public void applyOrdering(List<City> cities, CitySearchCondition citySearchCondition) {
        Comparator<City> cityComparator = null;

        CityFieldOrder majorField = citySearchCondition.getCityFieldOrder();

        switch (citySearchCondition.getOrderType()) {
            case OrderType.SIMPLE: {
                cityComparator = CityComparator.getInstance().getComparatorByField(majorField);
                break;
            }

            case OrderType.COMPLEX: {
                cityComparator = CityComparator.getInstance().getComplexComparator(majorField);
                break;
            }
        }

        switch (citySearchCondition.getOrderDirection()) {
            case OrderDirection.ASC: {
                cities.sort(cityComparator);
                break;
            }

            case OrderDirection.DESC: {
                cities.sort(cityComparator.reversed());
                break;
            }
        }
    }
}
