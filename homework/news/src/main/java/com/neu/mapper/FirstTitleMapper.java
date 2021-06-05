package com.neu.mapper;

import com.neu.po.FirstTitle;

import java.util.List;

public interface FirstTitleMapper {

    List<FirstTitle> getAll();

    int insert(FirstTitle firstTitle);

    FirstTitle getById(int fid);

    int delete(int fid);

    int update(FirstTitle firstTitle);
}
