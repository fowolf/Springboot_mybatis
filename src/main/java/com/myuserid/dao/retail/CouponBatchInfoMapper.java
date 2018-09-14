package com.myuserid.dao.retail;

import com.myuserid.pojo.dbentity.CouponBatchInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Administrator on 2018/7/13.
 * map database CouponBatchInfo table to class CouponBatchInfo
 */
@Mapper
public interface CouponBatchInfoMapper {

    @Select("select * from table")
    List<CouponBatchInfo> findAll();

    @Select("select * from table where id = #{id}")
    CouponBatchInfo findById(int id);
}
