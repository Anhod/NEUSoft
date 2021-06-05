package com.neu.service;

import com.github.pagehelper.PageInfo;
import com.neu.po.Goods;

import java.util.List;

public interface GoodsService {
    List<Goods> getAll();

    PageInfo<Goods> getPaged(int pageNum, int pageSize);

    Goods getById(String gid);

}
