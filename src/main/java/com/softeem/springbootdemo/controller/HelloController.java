package com.softeem.springbootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    //json:没  ajax:没  vue.js:没  jsp网页:学  thymeleaf:没
    @RequestMapping("/main")
    public String main(){
        return "main";
    }

    @RequestMapping("/top")
    public String top(){
        return "top";
    }

    @RequestMapping("/left")
    public String left(){
        return "left";
    }

    @RequestMapping("/show")
    public String show(){
        return "show";
    }
    @RequestMapping("/addBook")
    public String addBook(){
        return "addbook";
    }

    /**
     * 新添加的方法哈哈
     * @return 返回裴杰
     * @author peige
     */
    @RequestMapping("/addRecord2")
    @ResponseBody
    public String addRecord2(){
        System.out.println("裴杰2");
        return "peijie";
    }

    @RequestMapping("/addRecord3")
    @ResponseBody
    public String addRecord3(){
        System.out.println("裴杰3");
        return "peijie";
    }
}
