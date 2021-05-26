package com.neu.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyUser {
    private int userId;
    private String userName;
    private String password;
    private int uRoleId;

    private Role role;

    public MyUser(int id, String userName, String password, int roleId) {
        this.userId = id;
        this.userName = userName;
        this.password = password;
        this.uRoleId = roleId;
    }
}
