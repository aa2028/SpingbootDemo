package com.softeem.springbootdemo;

import com.github.pagehelper.PageInfo;
import com.softeem.springbootdemo.mapper.BookMapper;
import com.softeem.springbootdemo.mapper.RecordMapper;
import com.softeem.springbootdemo.mapper.UserMapper;
import com.softeem.springbootdemo.pojo.Book;
import com.softeem.springbootdemo.pojo.User;
import com.softeem.springbootdemo.service.BookService;
import com.softeem.springbootdemo.vo.RecordVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sun.util.resources.cldr.ti.CalendarData_ti_ER;

import java.lang.annotation.Target;
import java.util.List;

@SpringBootTest
class SpingbootDemoApplicationTests {
    @Autowired
    private BookMapper bookMapper ;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private BookService bookService ;
    @Autowired
    private RecordMapper recordMapper;

    @Test
    public void findRecordTest(){
        List<RecordVo> recordVoList = recordMapper.findRecrod(null);
        for (RecordVo recordVo : recordVoList) {
            System.out.println("recordVo = " + recordVo);
        }
    }

    @Test
    public  void pageTest(){
        PageInfo pageInfo = bookService.page(2, 3);
        List list = pageInfo.getList();

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
    @Test
    public void findUserByNameAndPasswordTest(){
        User user = new User();
        user.setName("张三");
        user.setPassword("1111");
        User u = userMapper.findUserByNameAndPassword(user);
        if(u == null){
            System.out.println("用户或密码错误!");
        }else{
            System.out.println("登录成功");
        }
    }

    @Test
    public void findAllBookTest(){
        List<Book> bookList = bookMapper.findAllBook();
        for (Book book : bookList) {
            System.out.println("book = " + book);
        }
    }

    @Test
    public void addBookTest(){
        Book book = new Book();
        book.setAuthor("张三");
        book.setName("java");
        book.setPress("清华大学出版社");
        bookMapper.addBook(book);
    }

}
