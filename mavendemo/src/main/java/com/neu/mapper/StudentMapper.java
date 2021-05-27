package com.neu.mapper;

import com.neu.po.Student;

public interface StudentMapper {
    int insert(Student student);
    int update(Student student);

    Student getById(int sid);
}
