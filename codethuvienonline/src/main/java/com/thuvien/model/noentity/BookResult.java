package com.thuvien.model.noentity;

import com.thuvien.model.Book;

import java.util.List;

public class BookResult {
    private List<Book> data;
    private Pagination pagination;

    public List<Book> getData() {
        return data;
    }

    public void setData(List<Book> data) {
        this.data = data;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }
}
