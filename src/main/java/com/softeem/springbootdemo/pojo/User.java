package com.softeem.springbootdemo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id ;
    private String name ;
    private String password ;
    private String email ;
    private String role ;
    private String status ;
}
