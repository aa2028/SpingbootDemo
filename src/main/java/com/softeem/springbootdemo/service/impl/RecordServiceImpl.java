package com.softeem.springbootdemo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.softeem.springbootdemo.mapper.BookMapper;
import com.softeem.springbootdemo.mapper.RecordMapper;
import com.softeem.springbootdemo.mapper.UserMapper;
import com.softeem.springbootdemo.pojo.Record;
import com.softeem.springbootdemo.service.RecordService;

import com.softeem.springbootdemo.vo.RecordVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RecordServiceImpl implements RecordService {
    @Autowired
    private RecordMapper recordMapper;
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private UserMapper userMapper;
    @Override
    public PageInfo findRecrod(String name, String role, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<RecordVo> recordVoList ;
        if(role.equals("ADMIN")){
            //是管理员,就查询所有借阅记录
            recordVoList = recordMapper.findRecrod(null);
        }else{
            //只查询的借阅记录
            recordVoList = recordMapper.findRecrod(name);
        }
        PageInfo pageInfo = new PageInfo(recordVoList);
        return pageInfo;
    }

    @Transactional //开启事务.最终效果要么成功都成功,要么失败都失败
    @Override
    public void updateRecrodStatus(Integer id) {
        recordMapper.updateRecrodStatus(id);//执行成功啦
        Record recrod = recordMapper.findRecrodById(id);
        bookMapper.updateBookStatus(recrod.getBookid(), 0);//把book表的中status字段设置为0[可借阅]
    }

    @Transactional //开启事务
    @Override
    public void addrecord(String userName, Integer bookId) {
        //通过此用户的名称.查询出他的主键id
        Integer userId = userMapper.findUserByName(userName).getId();
        Record record = new Record();
        record.setBookid(bookId);
        record.setUserid(userId);
        recordMapper.addrecord(record);
        bookMapper.updateBookStatus(bookId, 1);
    }
}
