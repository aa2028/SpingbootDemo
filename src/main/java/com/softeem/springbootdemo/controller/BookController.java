package com.softeem.springbootdemo.controller;

import com.github.pagehelper.PageInfo;
import com.softeem.springbootdemo.pojo.Book;
import com.softeem.springbootdemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService ;

    @RequestMapping("/findAllBook")
    public String findAllBook(@RequestParam(value = "pageNum" , defaultValue = "1") Integer pageNum ,
                              @RequestParam(value = "pageSize" , defaultValue = "5") Integer pageSize ,
                              Model model)
    {
        PageInfo pageInfo = bookService.page(pageNum , pageSize);
        model.addAttribute("pageInfo", pageInfo);
        return "success";
    }

    @RequestMapping("/saveOrUpdateBook")
    public String saveOrUpdateBook(Book book){
        bookService.saveOrUpdateBook(book);
        return "forward:/findAllBook" ;
    }

    @RequestMapping("/findBookById")
    public String findBookById(Integer id , Model model){
        Book book = bookService.findBookById(id);
        model.addAttribute("book",  book);
        return "addbook";
    }

    @RequestMapping("/deleteBookById")
    public String deleteBookById(Integer id){
        bookService.deleteBook(id);
        return "forward:/findAllBook";
    }
}
