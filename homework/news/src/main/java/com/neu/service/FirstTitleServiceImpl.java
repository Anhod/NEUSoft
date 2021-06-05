package com.neu.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neu.mapper.FirstTitleMapper;
import com.neu.po.FirstTitle;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Service
public

class FirstTitleServiceImpl implements FirstTitleService{
    @Resource
    private FirstTitleMapper firstTitleMapper;


    @Override
    public List<FirstTitle> getAll() {
        return firstTitleMapper.getAll();
    }

    @Override
    public int insert(FirstTitle firstTitle) {
        return firstTitleMapper.insert(firstTitle);
    }

    @Override
    public PageInfo<FirstTitle> getPaged(int pageNum, int pageSize) {
        // 分页方法，该方法会拦截该语句后的第一个查询，对该查询进行分页操作
        PageHelper.startPage(pageNum,pageSize);
        List<FirstTitle> list = firstTitleMapper.getAll();

        PageInfo<FirstTitle> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public FirstTitle getById(int fid) {
        return firstTitleMapper.getById(fid);
    }

    @Override
    public int delete(int fid) {
        return firstTitleMapper.delete(fid);
    }

    @Override
    public int update(FirstTitle firstTitle) {
        return firstTitleMapper.update(firstTitle);
    }
}
