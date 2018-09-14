package com.myuserid.dao.retailX;

import com.myuserid.pojo.dbentity.retailX.PKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Created by Administrator on 2018/7/13.
 * map database CouponBatchInfo table to class CouponBatchInfo
 */
@Mapper
public interface ProductKeyMapper {

    @Select("select * from table where channel = #{channel}")
    PKey getKeyByChannel(String channel);
}
