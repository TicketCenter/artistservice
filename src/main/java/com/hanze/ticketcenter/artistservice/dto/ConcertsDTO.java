package com.hanze.ticketcenter.artistservice.dto;

/**
 * The concerts DTO.
 *
 * @author      Nils Berlijn
 * @version     1.0
 * @since       1.0
 */
public class ConcertsDTO {
    /**
     * The amount of concerts.
     */
    private Integer totalItems;

    /**
     * The amount of concerts to show per page.
     */
    private Integer pageSize;

    /**
     * The current page.
     */
    private Integer pageNumber;

    /**
     * The amount of pages.
     */
    private Integer pageCount;

    /**
     * The concerts.
     */
    private Object concerts;

    /**
     * Get the amount of concerts.
     *
     * @return                  The amount of concerts.
     */
    public Integer getTotalItems() {
        return totalItems;
    }

    /**
     * Set the amount of total items.
     *
     * @param totalItems        The amount of concerts.
     */
    public void setTotalItems(Integer totalItems) {
        this.totalItems = totalItems;
    }

    /**
     * Get the amount of concerts to show per page.
     *
     * @return                  The amount of concerts to show per page.
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * Set the amount of concerts to show per page.
     *
     * @param pageSize          The amount of concerts to show per page.
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * Get the current page.
     *
     * @return                  The current page.
     */
    public Integer getPageNumber() {
        return pageNumber;
    }

    /**
     * Set the current page.
     *
     * @param pageNumber        The current page.
     */
    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    /**
     * Get the amount of pages.
     *
     * @return                  The amount of pages.
     */
    public Integer getPageCount() {
        return pageCount;
    }

    /**
     * Set the amount of pages.
     *
     * @param pageCount         The amount of pages.
     */
    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    /**
     * Get the concerts.
     *
     * @return                  The concerts.
     */
    public Object getConcerts() {
        return concerts;
    }

    /**
     * Set the concerts.
     *
     * @param concerts          The concerts.
     */
    public void setConcerts(Object concerts) {
        this.concerts = concerts;
    }
}
