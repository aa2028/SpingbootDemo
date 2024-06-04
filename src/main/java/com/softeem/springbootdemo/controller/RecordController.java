package com.softeem.springbootdemo.controller;

import com.github.pagehelper.PageInfo;
import com.softeem.springbootdemo.service.RecordService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class RecordController {
    @Autowired
    private RecordService recordService;


    @RequestMapping("returnBook")
    public String returnBook(Integer id){
        recordService.updateRecrodStatus(id);
        return "forward:/findRecrod";
    }

    @RequestMapping("/findRecrod")
    public String findRecrod(@RequestParam(name="pageNum" , defaultValue = "1") Integer pageNum ,
                           @RequestParam(name="pageSize" , defaultValue = "5") Integer pageSize,
                           HttpSession session,
                           Model model){
        //从session中获取用户名和角色
        String name = (String)session.getAttribute("name");//登录用户的用户名
        String role = (String)session.getAttribute("role");//登录用户的角色

        PageInfo pageInfo = recordService.findRecrod(name, role, pageNum, pageSize);

        model.addAttribute("pageInfo",pageInfo);
        return "showrecord";
    }

    @RequestMapping("/mytest")
    public String addRecord(Integer bookId , HttpSession session){
        //从session中获取用户名
        String userName = (String)session.getAttribute("name");
        recordService.addrecord(userName,bookId);
        return "forward:/findAllBook" ;
    }
}
