package com.example.dell.myapplication;

import cn.bmob.v3.BmobUser;

/**
 * Created by dell on 2015/11/5.
 */
public class User extends BmobUser {
    private String info;
    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
