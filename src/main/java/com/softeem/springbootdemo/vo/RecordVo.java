package com.softeem.springbootdemo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RecordVo {
    private Integer id;
    private String bookName ;
    private String userName ;
    private String borrowtime;
    private Integer status;
    private String returntime;
}
