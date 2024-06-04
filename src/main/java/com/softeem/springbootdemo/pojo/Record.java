package com.softeem.springbootdemo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Record {
    private Integer id;
    private Integer bookid;
    private Integer userid;
    private String borrowtime;
    private Integer status;
    private String returntime;
}
