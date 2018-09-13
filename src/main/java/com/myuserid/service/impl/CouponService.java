package com.myuserid.service.impl;

import com.myuserid.dao.retail.CouponBatchInfoMapper;
import com.myuserid.pojo.dbentity.CouponBatchInfo;
import com.myuserid.pojo.response.APIResponse;
import com.myuserid.service.ICouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * coupon service
 * Created by Administrator on 2018/7/16.
 */
@Service(value = "ICouponService")
public class CouponService implements ICouponService {

    private final CouponBatchInfoMapper couponBatchInfoMapper;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    public CouponService(CouponBatchInfoMapper couponBatchInfoMapper) {
        this.couponBatchInfoMapper = couponBatchInfoMapper;
    }

    @Override
    public APIResponse<List<CouponBatchInfo>> getCouponBatchInfo() {

        return new APIResponse<List<CouponBatchInfo>>().randerSucess(couponBatchInfoMapper.findAll());
    }

    @Override
    public APIResponse<CouponBatchInfo> getCouponBatchInfoById(int id) {
        return new APIResponse<CouponBatchInfo>().randerSucess(couponBatchInfoMapper.findById(id));
    }
}
