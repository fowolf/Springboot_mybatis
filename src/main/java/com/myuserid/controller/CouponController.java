package com.myuserid.controller;

import com.myuserid.pojo.dbentity.CouponBatchInfo;
import com.myuserid.pojo.response.APIResponse;
import com.myuserid.service.ICouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2018/7/13.
 * coupon service
 */
@RequestMapping("/coupon")
@RestController
public class CouponController {

    private final ICouponService couponService;

    @Autowired
    public CouponController(ICouponService couponService) {
        this.couponService = couponService;
    }

    @RequestMapping("/getbatchinfo")
    public ResponseEntity<APIResponse<List<CouponBatchInfo>>> getbatchinfo() {
        return new ResponseEntity<>(couponService.getCouponBatchInfo(), HttpStatus.OK);
    }

    @RequestMapping("/getbatchinfobyid")
    public ResponseEntity<APIResponse<CouponBatchInfo>> getBatchInfoById(int id) {
        return new ResponseEntity<>(couponService.getCouponBatchInfoById(id), HttpStatus.OK);
    }


}
