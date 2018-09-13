package com.myuserid.service;

import com.myuserid.pojo.dbentity.CouponBatchInfo;
import com.myuserid.pojo.response.APIResponse;

import java.util.List;

/**
 * Coupon service
 * Created by Administrator on 2018/7/16.
 */
public interface ICouponService {


    APIResponse<List<CouponBatchInfo>> getCouponBatchInfo();

    APIResponse<CouponBatchInfo> getCouponBatchInfoById(int id);
}
