package com.eec.controller;

import com.eec.model.TestEntity;
import com.eec.model.UserEntity;
import com.eec.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
* Created by Administrator on 2015/3/17.
*/
@Controller
public class TestController {
    @Autowired
    TestRepository testRepository;
    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/DataBaseOperation" ,method = RequestMethod.GET)
    public void DataBaseOperation(){
        try{
            System.out.println("测试。。。");
            System.out.println("测试吧。。。");
        }catch (Exception e){
            e.printStackTrace();
        }
//        try{
//            TestEntityRemote testEntityRemote = new TestEntityRemote();
//            testEntityRemote.setFrom("123");
//            testEntityRemote.setTo("123");
//            testEntityRemote.setMessage("123");
//            testRemoteRepository.save(testEntityRemote);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        ClientEntity clientEntity = new ClientEntity();
//        try{
//            System.out.println("测试ClientEntity");
//            clientEntity.setFrom("123");
////            clientEntity.setTo("shanghai");
////            userEntity.setContent("你好");
//            clientRepository.saveAndFlush(clientEntity);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        try{
//            UserEntity userEntity = new UserEntity();
//            userEntity.setFrom("小红");
//            userEntity.setTo("shanghai");
////            userEntity.setContent("你好");
//            userRepository.saveAndFlush(userEntity);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        testRepository.insertTest("1233","123","123","123");
        TestEntity testEntity = new TestEntity();
        //查
//        try{
//            List<TestEntity> list = testRepository.findAll();
//            for(int i=0;i<list.size();i++){
////                 testEntity = new TestEntity();
//                testEntity = list.get(i);
//                System.out.println("测试查询--"+testEntity.getId()+"    "+testEntity.getName());
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        //增
//        try {
//            testRepository.insertTest("11","22","33","44");
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        try{
            System.out.println("测试插入--");
            testEntity.setTestName("小明");
            testEntity.setTestTo("shanghai");
            testEntity.setMessage("测试");
            testEntity.setTime("2015-3-18");

            testRepository.saveAndFlush(testEntity);

        }catch (Exception e){
            e.printStackTrace();
        }
        //改
//        try{
//            System.out.println("测试修改--");
//            testRepository.setName("test");
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        //删
//        try{
//            System.out.println("测试删除--");
//            testRepository.delete(2);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
    }
}
