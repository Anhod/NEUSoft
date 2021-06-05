package com.neu.service;

import com.github.pagehelper.PageInfo;
import com.neu.po.FirstTitle;

import java.util.List;

public interface FirstTitleService {
    List<FirstTitle> getAll();

    int insert(FirstTitle firstTitle);

    PageInfo<FirstTitle> getPaged(int pageNum, int pageSize);

    FirstTitle getById(int fid);

    int delete(int fid);

    int update(FirstTitle firstTitle);
}
