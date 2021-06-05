package com.neu.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neu.mapper.GoodsMapper;
import com.neu.po.Goods;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService{
    @Resource
    private GoodsMapper goodsMapper;

    @Override
    public List<Goods> getAll() {
        return goodsMapper.getAll();
    }

    // 分页方法，该方法会拦截该语句后的第一个查询，对该查询进行分页操作
    @Override
    public PageInfo<Goods> getPaged(int pageNum, int pageSize) {
//        pageSize = 5;
        PageHelper.startPage(pageNum,pageSize);
        List<Goods> list = goodsMapper.getAll();

        PageInfo<Goods> pageInfo = new PageInfo<>(list);
        System.out.println(pageInfo);
        return pageInfo;
    }

    @Override
    public Goods getById(String gid) {
        return goodsMapper.getById(gid);
    }
}
