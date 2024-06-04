package com.softeem.springbootdemo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //生成get and set 方法
@NoArgsConstructor //生成无参构造方法
@AllArgsConstructor //生成满参数构造方法
public class Book {
    private Integer id;       //图书编号
    private String name;     //图书名称
    private String isbn;    //图书标准ISBN编号
    private String press;   //图书出版社
    private String author;  //图书作者
    private Double price;   //图书价格
    private Integer status; //状态:(0:可借阅,1:已借阅,2:归还中,3:已下架)
}
