package main.java.ru.elena.TravelAgency.v5.City.search;

import main.java.ru.elena.TravelAgency.v5.City.domain.City;
import main.java.ru.elena.TravelAgency.v5.common.solution.utils.ComparatorUtils;

import java.util.*;

import static main.java.ru.elena.TravelAgency.v5.City.search.CityFieldOrder.CLIMATE_TYPE;
import static main.java.ru.elena.TravelAgency.v5.City.search.CityFieldOrder.NAME;

public final class CityComparator {
    private static final CityComparator INSTANCE = new CityComparator();

    private CityComparator() {
    }

    private static Map<CityFieldOrder, Comparator<City>> comparatorsForFields = new HashMap<>();

    // Field order for complex search
    private static Set<CityFieldOrder> fieldPriority = new LinkedHashSet(Arrays.asList(NAME, CLIMATE_TYPE));

    static {
        comparatorsForFields.put(NAME, getComparatorForName());
        comparatorsForFields.put(CLIMATE_TYPE, getComparatorForClimateType());
    }

    public static CityComparator getInstance() {
        return INSTANCE;
    }

    private static Comparator<City> getComparatorForName() {
        return new Comparator<City>() {
            @Override
            public int compare(City city1, City city2) {
                return ComparatorUtils.getComparatorForNullableStrings().compare(city1.getName(), city2.getName());
            }
        };
    }

    private static Comparator<City> getComparatorForClimateType() {
        return new Comparator<City>() {
            @Override
            public int compare(City city1, City city2) {
                return ComparatorUtils.getComparatorForNullableStrings().compare(city1.getClimateType().name(),
                                                                 city2.getClimateType().name());
            }
        };
    }

    public Comparator<City> getComparatorByField(CityFieldOrder field) {
        return comparatorsForFields.get(field);
    }

    public Comparator<City> getComplexComparator(CityFieldOrder field) {
        return new Comparator<City>() {
            @Override
            public int compare(City city1, City city2) {
                int compareResult = 0;
                Comparator<City> comparatorByMajorField = getComparatorByField(field);

                if (comparatorByMajorField != null) {
                    compareResult = comparatorByMajorField.compare(city1, city2);

                    if (compareResult == 0)
                        for (CityFieldOrder otherField : fieldPriority) {
                            if (!otherField.equals(field))
                                compareResult = getComparatorByField(otherField).compare(city1, city2);

                            if (compareResult != 0)
                                break;
                        }
                }

                return compareResult;
            }
        };
    }
}