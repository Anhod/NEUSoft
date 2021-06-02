package com.neu.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neu.mapper.BookMapper;
import com.neu.po.Book;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class BookServicceImpl implements BookService{
    @Resource
    private BookMapper bookMapper;

    @Override
    public List<Book> getAll() {
        return bookMapper.getAll();
    }

    @Override
    public PageInfo<Book> getPaged(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);

        List<Book> list = bookMapper.getAll();
        PageInfo<Book> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public int insert(Book book){
        return bookMapper.insert(book);
    }

    @Override
    public int update(Book book) {
        return bookMapper.update(book);
    }

    @Override
    public Book getById(int bid) {
        return bookMapper.getById(bid);
    }
}
