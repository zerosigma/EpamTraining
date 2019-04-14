package com.elena.TravelAgency.v5.common.business.search;

import com.elena.TravelAgency.v5.common.application.ApplicationSettings;

public class Paginator {
    private int limit = ApplicationSettings.SEARCH_RESULTS_LIMIT_ON_PAGE;
    private int offset;

    public Paginator() {
    }

    public Paginator(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
}
