package br.com.gymleader.model;

import java.util.List;

public class PaginatedResponse<T> {
    private List<T> data;
    private int currentPage;
    private int pageSize;
    private long totalItems;
    private Integer nextPage;

    // Construtor
    public PaginatedResponse(List<T> data, int currentPage, int pageSize, long totalItems) {
        this.data = data;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalItems = totalItems;
        this.nextPage = (currentPage * pageSize) < totalItems ? currentPage + 1 : null;
    }

    // Getters
    public List<T> getData() {
        return data;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public long getTotalItems() {
        return totalItems;
    }

    public Integer getNextPage() {
        return nextPage;
    }
}