package com.dao;

import com.entity.Role;
import com.entity.Users;
import com.entity.qiandao;

import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Administrator on 2017/7/14 0014.
 */
@Repository
public interface UserDao {
     int getuid(String user_name);
     void addqiandao(qiandao qiandao);
     List<Role> getqx(String user_name);
     List<qiandao> gety(String user_name);
     List<qiandao> getj();
     List<qiandao> getall();
     Timestamp getoldtime(int uid);
     void delete1(int qid);


}
