package com.myuserid.dao;

import com.myuserid.pojo.dbentity.CouponBatchInfo;
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

    @Select("select * from StShopDataAnchor")
    List<StShopDataAnchor> findAll();

    @Select("select * from StShopDataAnchor where shopno = #{shopNo}")
    StShopDataAnchor findByShopNo(String shopNo);

    @Select("select * from StShopDataAnchor where id = #{id}")
    StShopDataAnchor getById(int id);

    @Update("update StShopDataAnchor set shopid=#{shopId}, shopno=#{shopNo}, dateline=#{dateLine}, createtime=#{createTime}, updatetime=#{updateTime} where id = #{id} ")
    int UpdateById(StShopDataAnchor shopDataAnchor);
}
