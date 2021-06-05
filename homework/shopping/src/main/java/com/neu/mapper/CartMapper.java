package com.neu.mapper;

import com.neu.po.Cart;
import com.sun.org.apache.xalan.internal.xsltc.dom.SimpleResultTreeImpl;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CartMapper {
    @Select("select * from cart")
    List<Cart> getAll();

    @Update("update cart set count=#{count} where bid = #{bid}")
    int update(Cart cart);

    @Select("select * from cart where bid = #{bid}")
    Cart getById(String bid);

    @Insert("insert into cart values (#{bid},#{bname},#{price},#{count})")
    int insert(Cart cart);

    @Delete("delete from cart where 1=1")
    int delete();
}
