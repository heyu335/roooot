package com.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Administrator on 2017/7/14 0014.
 */
public class qiandao implements Serializable {
    private int qid;
    private int uid;
    private Timestamp q_time;
    private String user_name;
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public qiandao() {
    }

    public qiandao(int qid, int uid, Timestamp q_time, String user_name, String state) {
        this.qid = qid;
        this.uid = uid;
        this.q_time = q_time;
        this.user_name = user_name;
        this.state = state;
    }

    public int getQid() {
        return qid;
    }

    public void setQid(int qid) {
        this.qid = qid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public Timestamp getQ_time() {
        return q_time;
    }

    public void setQ_time(Timestamp q_time) {
        this.q_time = q_time;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String toString(){
        return uid+qid+user_name;
    }



}
