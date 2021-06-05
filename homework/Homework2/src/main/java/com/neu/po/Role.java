package com.neu.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    private int roleId;
    private String name;

    List<MyUser> myUsers;

    public Role(int id, String name) {
        this.roleId = id;
        this.name = name;
    }
}
