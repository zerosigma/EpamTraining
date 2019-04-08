package com.elena.TravelAgency.v5.common.business.search;

public abstract class BaseSearchCondition<ID_TYPE> {
    protected ID_TYPE id;
    protected OrderDirection orderDirection;
    protected OrderType orderType;
    protected Paginator paginator;

    public ID_TYPE getId() {
        return id;
    }

    public void setId(ID_TYPE id) {
        this.id = id;
    }

    public OrderDirection getOrderDirection() {
        return orderDirection;
    }

    public void setOrderDirection(OrderDirection orderDirection) {
        this.orderDirection = orderDirection;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public Paginator getPaginator() {
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
