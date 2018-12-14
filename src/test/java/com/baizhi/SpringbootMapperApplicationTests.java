package com.baizhi;

import com.baizhi.entity.User;
import com.baizhi.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMapperApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Test
    public void contextLoads() {
        List<User> users = userMapper.selectAll();
        for (User user : users) {
            System.out.println(user);
        }
    }
    
    @Test
    public void test1(){
        User user = userMapper.selectByPrimaryKey(1);
        System.out.println(user);
    }

    @Test
    public void test2(){
        User t = new User();
        t.setPassword("123456");
        t.setName("陈凯歌");
        List<User> select = userMapper.select(t);
        for (User user : select) {
            System.out.println(user);
        }
    }

    @Test
    public void test3(){
        int i = userMapper.insert(new User( "陈个", "129445"));
        System.out.println(i);
    }

    @Test
    public void test4(){
        int i = userMapper.deleteByPrimaryKey(5);
        System.out.println(i);
    }

    @Test
    public void test5(){
        User t = new User(2,"凯歌","123457");
        userMapper.updateByPrimaryKey(t);

    }
}

