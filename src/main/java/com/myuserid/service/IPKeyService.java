package com.myuserid.service;

import com.myuserid.pojo.dbentity.retailX.PKey;

/**
 * Coupon service
 * Created by Administrator on 2018/7/16.
 */
public interface IPKeyService {


    PKey getKeyByChannel(String channel);

}