package com.softeem.springbootdemo.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.softeem.springbootdemo.pojo.Book;
import com.softeem.springbootdemo.pojo.User;

import java.util.List;

public interface BookService {
    public PageInfo page(Integer pageNum, Integer pageSize);

    public List<Book> findAllBook();

    public void saveOrUpdateBook(Book book);

    public Book findBookById(Integer id);

    public void deleteBook(Integer id);
}
