package com.neu.service;

import com.github.pagehelper.PageInfo;
import com.neu.po.Book;

import java.util.List;

public interface BookService {
    List<Book> getAll();

    PageInfo<Book> getPaged(int pageNum,int pageSize);

    int insert(Book book);

    int update(Book book);

    Book getById(int bid);
}
