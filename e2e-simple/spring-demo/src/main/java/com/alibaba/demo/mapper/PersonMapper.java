package com.alibaba.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.alibaba.demo.model.Person;

@Mapper
public interface PersonMapper {

    @Select("SELECT id as id, firstname as firstName, lastname as lastName FROM demo.person")
    List<Person> findAll();

}