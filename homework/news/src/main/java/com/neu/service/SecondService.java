package com.neu.service;

import com.github.pagehelper.PageInfo;
import com.neu.po.FirstTitle;
import com.neu.po.SecondTitle;

import java.util.List;

public interface SecondService {
    List<SecondTitle> getByFid(int parentTitleId);

    SecondTitle getById(int sid);

    PageInfo<SecondTitle> getPaged(int pageNum, int pageSize);

    List<SecondTitle> getAll();

    int insert(SecondTitle secondTitle);

    int delete(int sid);

    int update(SecondTitle secondTitle);
}
