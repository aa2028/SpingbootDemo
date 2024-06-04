package com.softeem.springbootdemo.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.softeem.springbootdemo.mapper.BookMapper;
import com.softeem.springbootdemo.pojo.Book;
import com.softeem.springbootdemo.pojo.User;
import com.softeem.springbootdemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service //此解释不能忘记了..一定要添加
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;

    /**
     * 分页查询方法
     * @param pageNum   当前页
     * @param pageSize  每页显示的数据记录
     * @return
     */
    @Override
    public PageInfo page(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Book> bookList = bookMapper.findAllBook();
        PageInfo pageInfo = new PageInfo(bookList);
        return pageInfo;
    }

    @Override
    public List<Book> findAllBook() {
        return bookMapper.findAllBook();
    }

    @Override
    public void saveOrUpdateBook(Book book) {
        // 判断id是否为空，不为空则修改，否则添加
        if(book.getId() != null){
            bookMapper.updateBook(book);
        }else{
            book.setStatus(0);//0是默认值
            bookMapper.addBook(book);
        }
    }

    @Override
    public Book findBookById(Integer id) {
        return bookMapper.findBookById(id);
    }

    @Override
    public void deleteBook(Integer id) {
        bookMapper.deleteBook(id);
    }
}
