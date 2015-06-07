package com.eec.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2015/3/16.
 */
public class Util {
    //获得字符串类型的日期
    public String getTimeDate(){
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//可以方便地修改日期格式
        String date = dateFormat.format( now );
//        Date date = dateFormat.format(now);
        System.out.println(date);
        return  date;
    }
    //获得Date型日期
    public Date getDate(){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date time = null;
        try {
            time= sdf.parse(sdf.format(new Date()));
            return time;

        } catch (ParseException e) {

            e.printStackTrace();
        }
        return null;
    }
    //把网址变成超链接形式
    public String textToLink(String text){
        String textLink = "";
        //正则表达式匹配
//        Pattern pattern = Pattern.compile("http:");
//        Matcher matcher = pattern.matcher(text);
//        if(matcher.find(0)){
//        if(text.indexOf("http:")!=-1 || text.indexOf("https:")!=-1){
        if(text.indexOf("http") != -1 || text.indexOf("www.")!=-1){
            System.out.println("11");
//            String tcontent="<a href='http://***************'>http://***************</a>";
            textLink = "<a href='"+text+"'>"+text+"</a>"+"<br/>";
//            textLink = text;
        }else{
            System.out.println("22");
            textLink = text+"<br/>";
        }
        System.out.println("textLink=="+textLink);
        return textLink;
    }
    //过滤掉最后一个回车字符
    public String deleteLastChar(String text){
        int textLength = text.length();
        String text2 = text.substring(0,textLength-1);
        return text2;
    }
}
