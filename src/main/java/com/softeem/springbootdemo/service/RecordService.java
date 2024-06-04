package com.softeem.springbootdemo.service;

import com.github.pagehelper.PageInfo;
import com.softeem.springbootdemo.vo.RecordVo;

import java.util.List;

public interface RecordService {
    /**
     * 查询借阅记录
     * 如果角色是admin的情况下.我们查询所有的借阅记录
     * 否则只查询本人的借阅记录
     * @param name 用户名
     * @param role 角色
     * @return
     */
    public PageInfo findRecrod(String name , String role, Integer pageNum, Integer pageSize);

    public void updateRecrodStatus(Integer id);

    public void addrecord(String userName , Integer bookId);
}
