package com.neu.mapper;

import com.neu.po.Goods;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface GoodsMapper {
    @Select("select * from goods")
    List<Goods> getAll();

    @Select("select * from goods where gid=#{gid}")
    Goods getById(String gid);
}
