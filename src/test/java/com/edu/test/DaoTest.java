//package com.edu.test;
//
//
//import com.edu.dao.UserMapper;
//import com.edu.entry.User;
//import com.edu.entry.UserExample;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.transaction.event.TransactionalEventListener;
//
//import java.util.List;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:applicationContext.xml"})//加载spring配置文件
//public class DaoTest {
//
//
//    @Autowired
//    private UserMapper userMapper;
//
//    @Test
//    public void testUserInsert(){
//        //创建一个User对象
//        User user = new User("周舟舟","12345","M","13281682261","四川省广安市");
//        //将对象增加到数据库中
//        userMapper.insertSelective(user);
//        System.out.println("success");
//    }
//    @Test
//    public void testSelectById(){
//        User user = userMapper.selectByPrimaryKey(1);
//
//        System.out.println(user.toString());
//    }
//    @Test
//    public void testSelectByExample(){
//        UserExample userExample = new UserExample();
//        userExample.createCriteria().andTelEqualTo("13281682261")
//                .andPasswordEqualTo("123456");
//        List<User> userList = userMapper.selectByExample(userExample);
//        for (User u:userList
//        ) {
//            System.out.println(u.toString());
//        }
//    }
//}
