package main.java.ru.elena.TravelAgency.v6.City.search;

import main.java.ru.elena.TravelAgency.v6.City.domain.City;
import main.java.ru.elena.TravelAgency.v6.common.solution.utils.ComparatorUtils;

import java.util.*;

public final class CityComparator {
    private static final CityComparator INSTANCE = new CityComparator();

    private CityComparator() {
    }

    private static Map<CityFieldOrder, Comparator<City>> comparatorsForFields = new HashMap<>();

    // Field order for complex search
    private static Set<CityFieldOrder> fieldPriority = new LinkedHashSet(Arrays.asList(CityFieldOrder.NAME, CityFieldOrder.CLIMATE_TYPE));

    static {
        comparatorsForFields.put(CityFieldOrder.NAME, getComparatorForName());
        comparatorsForFields.put(CityFieldOrder.CLIMATE_TYPE, getComparatorForClimateType());
    }

    public static CityComparator getInstance() {
        return INSTANCE;
    }

    private static Comparator<City> getComparatorForName() {
        return (city1, city2) -> ComparatorUtils.getComparatorForNullableStrings()
                                                .compare(city1.getName(), city2.getName());
    }

    private static Comparator<City> getComparatorForClimateType() {
        return (city1, city2) -> ComparatorUtils.getComparatorForNullableStrings()
                                                .compare(city1.getClimateType().name(),
                                                         city2.getClimateType().name());
    }

    public Comparator<City> getComparatorByField(CityFieldOrder field) {
        return comparatorsForFields.get(field);
    }

    public Comparator<City> getComplexComparator(CityFieldOrder field) {
        return (city1, city2) -> {
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
        };
    }
}