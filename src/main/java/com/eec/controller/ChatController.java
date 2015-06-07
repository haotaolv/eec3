package com.eec.controller;

import com.eec.model.ContentEntity;
import com.eec.model.UserEntity;
import com.eec.repository.ContentRepository;
import com.eec.repository.TestRepository;
import com.eec.repository.UserRepository;
import com.eec.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.*;
import java.util.*;

/**
 * Created by haitao on 2015/3/8.
 */
@Controller
public class ChatController {

    @Autowired
    ContentRepository contentRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    TestRepository testRepository;
//    @Autowired
//    ContentEntity contentEntity;
    //跳转到在线咨询页面
    @RequestMapping(value = "/onlineChat/{servername}",method = RequestMethod.GET)
    public String onlineConsult(HttpServletRequest request, HttpServletResponse response,
                                @PathVariable("servername") String servername){
        //随机生成一用户名，并放在Session中
//        Random random = new Random();
//        String userId = random.nextInt(100)+1+"";
//        System.out.println("userId=="+userId);
//        request.getSession().setAttribute("username","客户"+userId);
       //从Session中取出用户名
        String username = (String)request.getSession().getAttribute("username");
        //将用户信息标识放到application里
        ArrayList<UserEntity> userList;
        userList = (ArrayList<UserEntity>)RequestContextUtils.getWebApplicationContext(request).getServletContext()
                .getAttribute("userList");
        if(userList != null){
            UserEntity userEntity = new UserEntity();
//            userEntity.setName(username);
            userEntity.setUserName(username);
            userEntity.setServerName(servername);
            userList.add(userEntity);
            RequestContextUtils.getWebApplicationContext(request).getServletContext()
                    .setAttribute("userList", userList);
        }else {
            ArrayList<UserEntity> userListNew = new ArrayList<UserEntity>();
            UserEntity userEntity = new UserEntity();
            userEntity.setUserName(username);
            userEntity.setServerName(servername);
            userListNew.add(userEntity);
            RequestContextUtils.getWebApplicationContext(request).getServletContext()
                    .setAttribute("userList", userListNew);
        }
        request.getSession().setAttribute("userChatTag",username+"-"+servername);
        return "chat/onlineConsult";
    }
    //跳转到客服管理页面
    @RequestMapping(value = "/chatManager",method = RequestMethod.GET)
    public String chatManager(){
        return "chat/consultManager";
    }
    //发送聊天内容
    @RequestMapping(value = "/sendToServer", method = RequestMethod.GET)
    public void sendContent(HttpServletRequest request,HttpServletResponse response) throws Exception{

        String sendContent = request.getParameter("sendContent");
        sendContent = new String(sendContent.getBytes("ISO-8859-1"),"UTF-8");
        System.out.println("sendContent=="+sendContent);
        Util util = new Util();
//        sendContent = util.deleteLastChar(sendContent);
        System.out.println("sendContent2=="+sendContent);
        sendContent = util.textToLink(sendContent);
        System.out.println("sendContent3=="+sendContent);
        String userChatTag = (String)request.getSession().getAttribute("userChatTag");
        System.out.println("sendContent-username=="+userChatTag);
        String userChatContent = (String)request.getSession().getAttribute("username")+"说："+sendContent+"\r\n";
//        String userChatContent = sendContent;
        /*测试开始--表明jpa的配置是没问题的*/

        /*测试结束*/

        //保存聊天信息到数据库中
        try{
            ContentEntity contentEntity = new ContentEntity();
            String[] name = userChatTag.split("-");
            contentEntity.setTestFrom(name[0]);
            contentEntity.setTestTo(name[1]);
            System.out.println("name[0] name[1]=="+name[0]+"    "+name[1]);
            contentEntity.setMessage(sendContent);
//            contentEntity.setDate(new Timestamp(new java.util.Date().getTime()));
            contentEntity.setDate(new Timestamp(new java.util.Date().getTime()));
            System.out.println(new Timestamp(new java.util.Date().getTime()));
//            contentRepository.save(contentEntity);
            contentRepository.saveAndFlush(contentEntity);
            System.out.println("here");
        }catch (Exception e){
            e.printStackTrace();
        }

        //将本次聊天记录保存在application里
        ArrayList<HashMap<String,Object>> contentList;
        if(sendContent != "" && sendContent != null){
            request.getSession().setAttribute("joinFlag", "true");
            contentList = (ArrayList<HashMap<String,Object>>)RequestContextUtils.getWebApplicationContext(request)
                    .getServletContext().getAttribute("allChatContent");
//            contentList = (ArrayList<HashMap<String,Object>>)request.getSession().getAttribute("allChatContent");
            String historyChatContent = "";
            if(contentList != null && contentList.toString() != "") {//不是第一个发起会话
                HashMap<String, Object> hash;
                for (int i = 0; i < contentList.size(); i++) {
                    hash = contentList.get(i);
                    Set<Map.Entry<String, Object>> entrySet = hash.entrySet();
                    for (Map.Entry<String, Object> entry : entrySet) {
                        if (entry.getKey().toString().equals(userChatTag)) {//取出发起该会话用户的聊天内容
                            historyChatContent = entry.getValue().toString();
                        }
                    }
                }
                HashMap<String, Object> hashMap = new HashMap<String, Object>();
                hashMap.put(userChatTag, historyChatContent + userChatContent);
                contentList.add(hashMap);

                RequestContextUtils.getWebApplicationContext(request).getServletContext()
                        .setAttribute("allChatContent", contentList);
            } else{//第一个发起会话
                try {
                    contentList = new ArrayList<HashMap<String, Object>>();
                    HashMap<String, Object> hashMap = new HashMap<String, Object>();
                    hashMap.put(userChatTag, userChatContent);
                    contentList.add(hashMap);
                    RequestContextUtils.getWebApplicationContext(request).getServletContext()
                            .setAttribute("allChatContent", contentList);
                    System.out.println("contentList=="+contentList);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
    //轮询聊天
    @RequestMapping(value = "/check", method = RequestMethod.GET)
    public void checkNewChat(ModelMap modelMap,HttpServletRequest request,HttpServletResponse response){
        response.setContentType("text/xml;charset=UTF-8");
        response.setHeader("Cache-Control","no-cache");
//        String username = (String)request.getSession().getAttribute("username");
        String userChatTag = (String)request.getSession().getAttribute("userChatTag");
//        System.out.println("check-username=="+username);
        StringBuffer sb = new StringBuffer();
        String joinFlag = (String)request.getSession().getAttribute("joinFlag");
//        System.out.println("check--joinFlag==" + joinFlag);
        sb.append("<Lists>");
        sb.append("<joinFlag>");
        sb.append(joinFlag);
        sb.append("</joinFlag>");
        sb.append("</Lists>");
        try {
            PrintWriter pw = response.getWriter();
            pw.print(sb.toString());
            pw.close();
        }catch (Exception e){
            e.printStackTrace();
        }

//        return "";
    }
    //获取聊天内容
    @RequestMapping(value = "/fetch", method = RequestMethod.GET)
    public void fetchChatContent(HttpServletRequest request,HttpServletResponse response){
        response.setContentType("text/xml;charset=UTF-8");
        response.setHeader("Cache-Control","no-cache");
        String userChatTag = (String)request.getSession().getAttribute("userChatTag");

        ArrayList<HashMap<String,Object>> contentList;
        String userChatContent = "";
        contentList = (ArrayList<HashMap<String,Object>>)RequestContextUtils.getWebApplicationContext(request).getServletContext()
                .getAttribute("allChatContent");
        HashMap<String, Object> hash;
        for (int i = 0; i < contentList.size(); i++) {
            hash = contentList.get(i);
            Set<Map.Entry<String, Object>> entrySet = hash.entrySet();
            for (Map.Entry<String, Object> entry : entrySet) {
                if (entry.getKey().toString().equals(userChatTag)) {
                    userChatContent = entry.getValue().toString();
                }
            }
        }
        System.out.println("userChatContent=="+userChatContent);
        System.out.println("modify...");
        StringBuffer sb = new StringBuffer();
        /*测试嵌入到HTML网页中*/
//        sb.append("<p>");
//        sb.append("<a href='https://www.baidu.com'>");
//        sb.append("https://www.baidu.com");
//        sb.append("</a>");
//        sb.append("</p>");

//        sb.append("<Lists>");
//        sb.append("<joinContent>");
//        sb.append(userChatContent);
//        sb.append("</joinContent>");
//        sb.append("</Lists>");
//        System.out.println("hello,world!");
        try{
            PrintWriter pw = response.getWriter();
//            pw.print(sb.toString());
            pw.print(userChatContent);
            pw.close();
        }catch (Exception e){
            e.printStackTrace();
        }

//        return "";
    }
    //设置用户下线
    @RequestMapping(value = "/dealErr", method = RequestMethod.GET)
    public void dealErr(ModelMap modelMap,HttpServletRequest request,HttpServletResponse response){

        response.setContentType("text/xml;charset=UTF-8");
        response.setHeader("Cache-Control","no-cache");
        request.getSession().setAttribute("joinFlag","false");
    }
}
