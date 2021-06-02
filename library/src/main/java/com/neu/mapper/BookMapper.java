package com.neu.mapper;

import com.neu.po.Book;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

public interface BookMapper {
    @Select("select * from book")
    List<Book> getAll();

    @Insert("insert into book(bid, bname, author, publish, publishDate, page, price, content) VALUES (#{bid},#{bname},#{author},#{publish},#{publishDate},#{page},#{price},#{content})")
    int insert(Book book);

    @Update("update book set bid=#{bid},bname=#{bname},author=#{author},publish=#{publish},publishDate=#{publishDate},page=#{page}," +
            "price=#{price},content=#{content} where bid =#{bid}")
    int update(Book book);

    @Select("select * from book where bid = #{bid}")
    Book getById(int bid);

}
