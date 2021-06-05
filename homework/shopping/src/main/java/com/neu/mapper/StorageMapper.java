package com.neu.mapper;

import com.neu.po.Storage;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.List;

public interface StorageMapper {
    @Select("select * from storage")
    List<Storage> getAll();

    @Select("select * from storage where gid=#{gid}")
    Storage getById(String gid);

    @Update("update storage set g_count=${g_count} where gid=${gid}")
    int update(Storage storage);
}
