package com.example.demo.huyue.design.xiangyuan;

import lombok.Data;

/**
 * @author huyue01@sinovatech.com 2019/12/22 16:40
 */
@Data
public class User {
    private String account;
    private String password;

    public User(String account, String password) {
        this.account = account;
        this.password = password;
    }
}
