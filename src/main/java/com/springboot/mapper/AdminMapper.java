package com.springboot.mapper;

import com.springboot.Model.Administrator;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AdminMapper {

    @Select("select name, password from administrator")
    public List<Administrator> getAll();

}
