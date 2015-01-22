package com.hanze.ticketcenter.artistservice.dto;

/**
 * The artists DTO.
 *
 * @author Nils Berlijn
 * @version 1.0
 * @since 1.0
 */
public class ArtistsDTO {
    /**
     * The amount of artists.
     */
    private Integer totalItems;

    /**
     * The amount of artists to show per page.
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
     * The artists.
     */
    private Object artists;

    /**
     * Get the amount of artists.
     *
     * @return The amount of artists.
     */
    public Integer getTotalItems() {
        return totalItems;
    }

    /**
     * Set the amount of total items.
     *
     * @param totalItems The amount of artists.
     */
    public void setTotalItems(Integer totalItems) {
        this.totalItems = totalItems;
    }

    /**
     * Get the amount of artists to show per page.
     *
     * @return The amount of artists to show per page.
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * Set the amount of artists to show per page.
     *
     * @param pageSize The amount of artists to show per page.
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * Get the current page.
     *
     * @return The current page.
     */
    public Integer getPageNumber() {
        return pageNumber;
    }

    /**
     * Set the current page.
     *
     * @param pageNumber The current page.
     */
    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    /**
     * Get the amount of pages.
     *
     * @return The amount of pages.
     */
    public Integer getPageCount() {
        return pageCount;
    }

    /**
     * Set the amount of pages.
     *
     * @param pageCount The amount of pages.
     */
    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    /**
     * Get the artists.
     *
     * @return The artists.
     */
    public Object getArtists() {
        return artists;
    }

    /**
     * Set the artists.
     *
     * @param artists The artists.
     */
    public void setArtists(Object artists) {
        this.artists = artists;
    }
}
