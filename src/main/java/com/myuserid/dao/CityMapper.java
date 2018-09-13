package com.myuserid.dao;

import com.myuserid.pojo.dbentity.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Administrator on 2018/7/13.
 * map database city table to class city
 */
@Mapper
public interface CityMapper {

    @Select("select * from city")
    List<City> findAll();
}
