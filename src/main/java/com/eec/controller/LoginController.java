package com.eec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Random;

/**
 * Created by haitao on 2015/3/9.
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/loginUser",method = RequestMethod.GET)
    public String loginUser(){
        return "loginUser";
    }
    @RequestMapping(value = "/loginServer",method = RequestMethod.GET)
    public String loginServer(){
        return "loginServer";
    }
    @RequestMapping(value = "/loginUserDao",method = RequestMethod.GET)
    public String loginUserDao(HttpServletRequest request){

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        request.getSession().setAttribute("username","客户"+username);
        return "index";
    }
    @RequestMapping(value = "/loginServerDao",method = RequestMethod.GET)
    public String loginServerDao(HttpServletRequest request){
        String servername = request.getParameter("servername");
        request.getSession().setAttribute("servername",servername);
        return "chat/consultManager";
    }
    @RequestMapping(value = "/setName",method = RequestMethod.GET)
    public void setUserName(HttpServletRequest request,HttpServletResponse response){

//        String username = request.getParameter("name");
//        if(username != "" && username != null && username != "null"){
//            request.getSession().setAttribute("server",username);
//        }else{
        Random random = new Random();
        String userId = random.nextInt(100)+1+"";
        System.out.println("userId=="+userId);
        request.getSession().setAttribute("username","客户"+userId);

        Cookie user = new Cookie("user","客户"+userId);
        user.setMaxAge(300);
        response.addCookie(user);
        System.out.println("setName-user=="+user);
//        }

//        return "";
    }

    @RequestMapping(value = "/setNameServer",method = RequestMethod.GET)
    public void setServerName(HttpServletRequest request, @PathVariable("servername") String servername){
        request.getSession().setAttribute("servername",servername);
    }
}
