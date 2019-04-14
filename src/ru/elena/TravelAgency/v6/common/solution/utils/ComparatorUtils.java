package ru.elena.TravelAgency.v6.common.solution.utils;

import java.util.Comparator;

public final class ComparatorUtils {
    private ComparatorUtils () {

    }

    private static Comparator<String> comparatorForNullableStrings = new Comparator<String>() {
        @Override
        public int compare(String str1, String str2) {
            if (str1 == null && str2 == null)
                return 0;
            else if (str1 != null)
                return str1.compareTo(str2);
            else
                return -1;
        }
    };

    public static Comparator<String> getComparatorForNullableStrings() {
        return comparatorForNullableStrings;
    }
}
