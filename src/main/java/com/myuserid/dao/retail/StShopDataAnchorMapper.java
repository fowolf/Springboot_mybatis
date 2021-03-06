package com.myuserid.dao.retail;

import com.myuserid.pojo.dbentity.StShopDataAnchor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by Administrator on 2018/7/13.
 * map database CouponBatchInfo table to class CouponBatchInfo
 */
@Mapper
public interface StShopDataAnchorMapper {

    @Select("select * from table")
    List<StShopDataAnchor> findAll();

    @Select("select * from table where shopno = #{shopNo}")
    StShopDataAnchor findByShopNo(String shopNo);

    @Select("select * from table where id = #{id}")
    StShopDataAnchor getById(int id);

    @Update("update table set shopid=#{shopId}, shopno=#{shopNo}, dateline=#{dateLine}, createtime=#{createTime}, updatetime=#{updateTime} where id = #{id} ")
    int UpdateById(StShopDataAnchor shopDataAnchor);
}
