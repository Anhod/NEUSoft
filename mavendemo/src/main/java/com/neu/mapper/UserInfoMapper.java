package com.neu.mapper;

import com.neu.po.UserInfo;
import org.apache.ibatis.annotations.Select;

public interface UserInfoMapper {
    // 插入数据，得到自动增长的主键值
    int insert(UserInfo userInfo);

    // sql语句起别名
    UserInfo getById(int id);

    // 进行映射，xml文件中resultMap
    UserInfo getById1(int id);

    // ----------------------------------第三天------------------------------
    @Select("select * from userinfo where id = #{id}")
    UserInfo getById2(int id);
}
