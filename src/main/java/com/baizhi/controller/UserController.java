package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    UserMapper userMapper;
    @RequestMapping("test")
    @ResponseBody
    public List<User> testSelectAll(HttpSession session){
        List<User> users = userMapper.selectAll();
        session.setAttribute("list",users);
        return users;
        //return "redirect:/testAll.jsp";
    }

    @RequestMapping("test2")
    @ResponseBody
    public User testSelectOne(HttpSession session){
        User user = userMapper.selectByPrimaryKey(62);
        session.setAttribute("user",user);
        return user;
//        return "redirect:/testAll.jsp";
    }
}
