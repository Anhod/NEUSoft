package com.neu.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neu.mapper.SecondMapper;
import com.neu.po.FirstTitle;
import com.neu.po.SecondTitle;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SecondServiceImpl implements SecondService{
    @Resource
    private SecondMapper secondMapper;

    @Override
    public List<SecondTitle> getByFid(int parentTitleId) {
        return secondMapper.getByFid(parentTitleId);
    }

    @Override
    public SecondTitle getById(int sid) {
        return secondMapper.getById(sid);
    }

    @Override
    public PageInfo<SecondTitle> getPaged(int pageNum, int pageSize) {
        // 分页方法，该方法会拦截该语句后的第一个查询，对该查询进行分页操作
        PageHelper.startPage(pageNum,pageSize);
        List<SecondTitle> list = secondMapper.getAll();

        PageInfo<SecondTitle> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public List<SecondTitle> getAll() {
        return secondMapper.getAll();
    }

    @Override
    public int insert(SecondTitle secondTitle) {
        return secondMapper.insert(secondTitle);
    }

    @Override
    public int delete(int sid) {
        return secondMapper.delete(sid);
    }

    @Override
    public int update(SecondTitle secondTitle) {
        return secondMapper.update(secondTitle);
    }
}
