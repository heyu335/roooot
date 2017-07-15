package com.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/7/15 0015.
 */
public class Role implements Serializable{
    private String role_name;
    private int rid;

    public Role(String role_name, int rid) {
        this.role_name = role_name;
        this.rid = rid;
    }

    public Role() {
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }
}
