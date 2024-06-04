package com.softeem.springbootdemo.mapper;

import com.softeem.springbootdemo.pojo.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//@Mapper 此注解也不会用加.可以在主启动类添加@MapperScan("com.softeem.spingbootdemo.mapper")
public interface BookMapper {

    public void addBook(Book book);

    public void deleteBook(Integer id);

    public void updateBook(Book book);

    public List<Book> findAllBook();

    public Book findBookById(Integer id);

    public void updateBookStatus(@Param("id") Integer id , @Param("status") Integer status);

}
