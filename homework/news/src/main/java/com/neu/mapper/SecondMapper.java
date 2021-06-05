package com.neu.mapper;

import com.neu.po.SecondTitle;

import java.util.List;

public interface SecondMapper {
    List<SecondTitle> getByFid(int parentTitleId);

    SecondTitle getById(int sid);

    List<SecondTitle> getAll();

    int insert(SecondTitle secondTitle);

    int delete(int sid);

    int update(SecondTitle secondTitle);
}
