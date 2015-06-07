package com.eec.controller;

import com.eec.model.UserEntity;
import com.eec.util.Util;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by Administrator on 2015/3/10.
 */
@Controller
public class ChatServerController {

    //跳转到客服管理页面
    @RequestMapping(value = "/chatManagerServer",method = RequestMethod.GET)
    public String chatManager(HttpServletRequest request){

//        request.getSession().setAttribute("servername","shanghai");
        return "chat/consultManager";
    }
    //查询当前在线客户列表
    @RequestMapping(value = "/checkUserList",method = RequestMethod.GET)
    public void checkUserList(HttpServletRequest request,HttpServletResponse response){
        ArrayList<UserEntity> userEntities ;
        userEntities = (ArrayList<UserEntity>)RequestContextUtils.getWebApplicationContext(request).getServletContext()
                .getAttribute("userList");
        StringBuffer sb = new StringBuffer();
        for(int i=0;i < userEntities.size();i++){
            if(userEntities.get(i).getServerName().equals(request.getSession().getAttribute("servername").toString())){
                String username = userEntities.get(i).getUserName();
                String to = userEntities.get(i).getServerName();
                sb.append("<tr>");
                sb.append("<td>");
                sb.append(username);
                sb.append("</td>");
                sb.append("<td>");
                sb.append(to);
                sb.append("</td>");
                sb.append("<td><a href='/openNewChatPage/"+username+"' target='_blank'>");
                sb.append("接受会话请求");
                sb.append("</a></td>");
                sb.append("</tr>");
            }
        }
        try {
            PrintWriter pw = response.getWriter();
            pw.print(sb.toString());
            pw.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @RequestMapping(value = "/openNewChatPage/{username}",method = RequestMethod.GET)
    public String openNewChatPage(HttpServletRequest request,HttpServletResponse response,
                                  @PathVariable("username") String username)throws Exception{

        String clientName = new String(username.getBytes("ISO-8859-1"),"UTF-8");
        String localName = (String)request.getSession().getAttribute("servername");
        System.out.println("openNewChatPage-localName-username=="+localName+"   "+clientName);

        //  避免同一PC多浏览器窗口不同账户共用session
        Random random = new Random();
        StringBuffer sid = new StringBuffer();
        sid = sid.append(System.currentTimeMillis());   //  取系统时间
        //  加上10为0-9随机数确保sid不重复
//        for (int i = 0; i < 10; i++) {
//            sid = sid.append(random.nextInt(10));
//        }
        //  把所有需要放进session的attribute放进一个sessionMap<String, String>
        //  一是便取值、二是便于统一管理
        Map<String,String> sessionMap = new HashMap<String,String>();
        sessionMap.put("localServiceName", clientName+"-"+localName);
        request.getSession().setAttribute(sid.toString(), sessionMap);
        request.setAttribute("sessionId",sid.toString());
        return "chat/serviceConsult";
    }
    @RequestMapping(value = "/checkChatContent",method = RequestMethod.GET)
    public void checkChatContent(HttpServletRequest request,HttpServletResponse response){

        String sessionId = request.getParameter("sessionId");
        Map<String,String> sessionMap = (Map)request.getSession().getAttribute(sessionId);
        String localServerTag = sessionMap.get("localServiceName");
        ArrayList<HashMap<String,Object>> contentList;
        String userChatContent = "";
        contentList = (ArrayList<HashMap<String,Object>>)RequestContextUtils.getWebApplicationContext(request)
                .getServletContext().getAttribute("allChatContent");
        HashMap<String, Object> hash;
        for (int i = 0; i < contentList.size(); i++) {
            hash = contentList.get(i);
            Set<Map.Entry<String, Object>> entrySet = hash.entrySet();
            for (Map.Entry<String, Object> entry : entrySet) {
                if (entry.getKey().toString().equals(localServerTag)) {
                    userChatContent = entry.getValue().toString();
                }
            }
        }
//        StringBuffer sb = new StringBuffer();
//        sb.append("<Lists>");
//        sb.append("<chatContent>");
//        sb.append(userChatContent);
//        sb.append("</chatContent>");
//        sb.append("</Lists>");
        try{
            PrintWriter pw = response.getWriter();
//            pw.print(sb.toString());
            pw.print(userChatContent);
            pw.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //发送聊天内容
    @RequestMapping(value = "/sendServer", method = RequestMethod.GET)
    public void sendContentServer(HttpServletRequest request,HttpServletResponse response) throws Exception{

        String sendContent = request.getParameter("sendContent");
        String sessionId = request.getParameter("sessionId");
        sendContent = new String(sendContent.getBytes("ISO-8859-1"),"UTF-8");

        System.out.println("sendContent sessionId=="+sendContent+"  "+sessionId);
        Util util = new Util();
        sendContent = util.textToLink(sendContent);
        String serviceChatContent = (String)request.getSession().getAttribute("servername")+"说："+sendContent+"\r\n";
        Map<String,String> sessionMap = (Map)request.getSession().getAttribute(sessionId);
        String localServerTag = sessionMap.get("localServiceName");
        System.out.println("sendServer-localServiceName="+localServerTag);

        ArrayList<HashMap<String,Object>> contentList;
        if(sendContent != "" && sendContent != null){
            contentList = (ArrayList<HashMap<String,Object>>)RequestContextUtils.getWebApplicationContext(request)
                    .getServletContext().getAttribute("allChatContent");
            String historyChatContent = "";
            if(contentList != null && contentList.toString() != "") {
                HashMap<String, Object> hash;
                for (int i = 0; i < contentList.size(); i++) {
                    hash = contentList.get(i);
                    Set<Map.Entry<String, Object>> entrySet = hash.entrySet();
                    for (Map.Entry<String, Object> entry : entrySet) {
                        if (entry.getKey().toString().equals(localServerTag)) {//取出发起该会话用户的聊天内容
                            historyChatContent = entry.getValue().toString();
                        }
                    }
                }
                HashMap<String, Object> hashMap = new HashMap<String, Object>();
                hashMap.put(localServerTag, historyChatContent + serviceChatContent);
                contentList.add(hashMap);

                RequestContextUtils.getWebApplicationContext(request).getServletContext()
                        .setAttribute("allChatContent", contentList);
                System.out.println("sendServer-allChatContent="+contentList);
            } else{
                contentList = new ArrayList<HashMap<String, Object>>();
                HashMap<String,Object> hashMap = new HashMap<String, Object>();
                hashMap.put(localServerTag,serviceChatContent);
                contentList.add(hashMap);
                RequestContextUtils.getWebApplicationContext(request).getServletContext()
                        .setAttribute("allChatContent", contentList);
                System.out.println("sendServer-first-allChatContent="+contentList);
            }
        }
    }
}
