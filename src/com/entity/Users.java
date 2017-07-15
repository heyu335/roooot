package com.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2017/7/14 0014.
 */
public class Users implements Serializable {
    private String user_name;
    private String pass;
    private int uid;
   /* private Set<Zhi> set = new HashSet<Zhi>();*/

    public String getPass() {
        return pass;
    }

    public int getUid() {
        return uid;
    }

    /*public Set<Zhi> getSet() {
        return set;
    }*/

    public String getUser_name() {
        return user_name;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    /*public void setSet(Set<Zhi> set) {
        this.set = set;
    }*/

    public void setUid(int uid) {
        this.uid = uid;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Users() {
        super();
    }

    public Users(String user_name, String pass, int uid) {
        this.user_name = user_name;
        this.pass = pass;
        this.uid = uid;

    }
}
