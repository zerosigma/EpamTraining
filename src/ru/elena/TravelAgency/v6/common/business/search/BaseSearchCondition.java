package ru.elena.TravelAgency.v6.common.business.search;

import ru.elena.TravelAgency.v5.common.business.search.OrderDirection;
import ru.elena.TravelAgency.v5.common.business.search.OrderType;
import ru.elena.TravelAgency.v5.common.business.search.Paginator;

public abstract class BaseSearchCondition<ID_TYPE> {
    protected ID_TYPE id;
    protected ru.elena.TravelAgency.v5.common.business.search.OrderDirection orderDirection;
    protected ru.elena.TravelAgency.v5.common.business.search.OrderType orderType;
    protected ru.elena.TravelAgency.v5.common.business.search.Paginator paginator;

    public ID_TYPE getId() {
        return id;
    }

    public void setId(ID_TYPE id) {
        this.id = id;
    }

    public ru.elena.TravelAgency.v5.common.business.search.OrderDirection getOrderDirection() {
        return orderDirection;
    }

    public void setOrderDirection(OrderDirection orderDirection) {
        this.orderDirection = orderDirection;
    }

    public ru.elena.TravelAgency.v5.common.business.search.OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public ru.elena.TravelAgency.v5.common.business.search.Paginator getPaginator() {
        return paginator;
    }

    public void setPaginator(Paginator paginator) {
        this.paginator = paginator;
    }

    public boolean searchById() {
        return id != null;
    }

    public boolean needOrdering() {
        return orderDirection != null && orderType != null;
    }

    public boolean needPaginate() {
        return paginator != null && paginator.getLimit() > 0 && paginator.getOffset() >= 0;
    }
}
