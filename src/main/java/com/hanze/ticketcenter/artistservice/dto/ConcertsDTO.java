package com.hanze.ticketcenter.artistservice.dto;

public class ConcertsDTO {
    private Integer totalItems;
    private Integer pageSize;
    private Integer pageNumber;
    private Integer pageCount;
    private Object concerts;

    public Integer getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(Integer totalItems) {
        this.totalItems = totalItems;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Object getConcerts() {
        return concerts;
    }

    public void setConcerts(Object concerts) {
        this.concerts = concerts;
    }
}
