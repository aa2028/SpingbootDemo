package com.softeem.springbootdemo.mapper;

import com.softeem.springbootdemo.pojo.Record;
import com.softeem.springbootdemo.vo.RecordVo;

import java.util.List;

public interface RecordMapper {
    /**
     * 此查询方法中,可以使用用户名来进行查询
     * 如果用户来为null,那么就查询所有的记录
     * @param name
     * @return
     */
    public List<RecordVo> findRecrod(String name);

    public int updateRecrodStatus(Integer id);

    public Record findRecrodById(Integer userid);

    public void addrecord(Record record);
}
