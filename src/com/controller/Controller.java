package com.controller;

import com.dao.UserDao;
import com.entity.Role;
import com.entity.Users;
import com.entity.qiandao;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import javax.annotation.Resource;
import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/7/14 0014.
 */

@org.springframework.stereotype.Controller
public class Controller {

    @Resource
    private UserDao dao;
    @RequestMapping("login.do")
    public String login( String user_name, String pass, HttpSession session){

        try {
            Subject user = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(user_name,pass);
            user.login(token);
            Users users = new Users();
           int uid = dao.getuid(user_name);

           users.setPass(pass);
           users.setUid(uid);
           users.setUser_name(user_name);
            session.setAttribute("user",users);
            return "redirect:/main.do";
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
    }
  /*  @RequestMapping("qiandao.do")
    public String qiandao(HttpServletSession session){
        int uid =session.getAttribute();
        dao.qianxian( uid);


    }*/
  @RequestMapping("main.do")

    public ModelAndView sall(ModelAndView modelAndView, HttpSession session){

   List<qiandao> list=null;
     Users users = (Users) session.getAttribute("user");
     int uid = users.getUid();
     String user_name = users.getUser_name();
      List<Role> listr  =dao.getqx(user_name);
     int i =0;
     for(int n=0;n<listr.size();n++){
         if("root".equals(listr.get(n).getRole_name())){
             i=1;
             break;
         }else if("经理".equals(listr.get(n).getRole_name())){
             i=2;
             break;
         }
     }
     if(i==0){
        list= dao.gety(user_name);
     }else if(i==1){
         list=dao.getall();
     }else if(i==2){
         list=dao.getj();
     }
      System.out.println(list);
     modelAndView.addObject("list",list);
     modelAndView.setViewName("forward:/admin/main.jsp");
      return modelAndView;
  }
  @RequestMapping("add.do")
  public String addqd(HttpSession session) throws ParseException {
        Users users=(Users) session.getAttribute("user");
        qiandao qiandao=new qiandao();
        int i =0;
      String state="正常打卡";
      SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
      SimpleDateFormat formatd = new SimpleDateFormat("yyyy-MM-dd");
      Date date_now =new Timestamp(new Date().getTime());
     Date data_old = dao.getoldtime(users.getUid());
     if(data_old!=null) {
         String strdo = formatd.format(data_old);
         String strdn = formatd.format(date_now);
         if (formatd.parse(strdn).getTime() == formatd.parse(strdo).getTime()) {
             return "redirect:/main.do";
         }
     }
         String datastr = format.format(date_now);
         try {
             Date date = format.parse("09:00:00");
             Date date_n = format.parse(datastr);
             if (date.getTime() >= date_n.getTime()) {
                 i = 0;
             } else {
                 i = 1;
             }
         } catch (ParseException e) {
             e.printStackTrace();
         }


      if(i==0){
          qiandao.setState(state);

      }else{
          state="迟到";
          qiandao.setState(state);
      }

      qiandao.setUid(users.getUid());
      qiandao.setQ_time((Timestamp) date_now);
      dao.addqiandao(qiandao);

        return "redirect:/main.do";
  }
  @RequestMapping("delete.do")
    public String delete1(int qid){
        dao.delete1(qid);
        return "redirect:/main.do";
  }


}
