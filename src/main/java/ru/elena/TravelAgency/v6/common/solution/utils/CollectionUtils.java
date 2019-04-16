package main.java.ru.elena.TravelAgency.v6.common.solution.utils;

import java.util.List;

public final class CollectionUtils {
    private CollectionUtils() {}

    public static <T> List<T> nextPageWithData(List<T> dataList, final int offset, final int limit) {
        if (offset >= dataList.size())
            return dataList;
        else {
            int rightShift = offset + limit > dataList.size() ? dataList.size() % limit : limit;
            return dataList.subList(offset, offset + rightShift);
        }
    }
}
