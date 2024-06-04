package com.softeem.springbootdemo.controller;


import com.softeem.springbootdemo.pojo.User;
import com.softeem.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/checkLogin")
    public String checkLogin(User user , Model model, HttpSession session){
        Map map = userService.checkLogin(user);
        boolean flag = (boolean)map.get("b");
        if( flag ){
            session.setAttribute("role" , map.get("role"));
            session.setAttribute("name", user.getName());
            //请求转发
            //return "redirect:/findAllBook"; //重定向跳转
            return "forward:/main";//请求转发跳转
            //return "findAllBook";//成功了跳转到success.html
        }else{
            model.addAttribute("msg","用户名或密码错误");
            //model.addAttribute("user", user);
            return "login";//失败跳转到login.html
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "login";
    }
}
