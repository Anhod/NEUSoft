package com.neu.service;

import com.github.pagehelper.PageInfo;
import com.neu.po.Storage;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StorageService {

    List<Storage> getAll();

    Storage getById(String gid);

    PageInfo<Storage> getPaged(int pageNum, int pageSize);

    int update(Storage storage);
}
