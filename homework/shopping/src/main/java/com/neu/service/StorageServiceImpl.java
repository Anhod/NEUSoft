package com.neu.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neu.mapper.StorageMapper;
import com.neu.po.Storage;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StorageServiceImpl implements StorageService{
    @Resource
    private StorageMapper storageMapper;


    @Override
    public List<Storage> getAll() {
        return storageMapper.getAll();
    }

    @Override
    public Storage getById(String gid) {
        return storageMapper.getById(gid);
    }

    @Override
    public PageInfo<Storage> getPaged(int pageNum, int pageSize) {
        // 分页方法，该方法会拦截该语句后的第一个查询，对该查询进行分页操作
        PageHelper.startPage(pageNum,pageSize);
        List<Storage> list = storageMapper.getAll();

        PageInfo<Storage> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public int update(Storage storage) {
        return storageMapper.update(storage);
    }


}
