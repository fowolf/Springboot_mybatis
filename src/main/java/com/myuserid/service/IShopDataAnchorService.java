package com.myuserid.service;

import com.myuserid.pojo.dbentity.StShopDataAnchor;
import com.myuserid.pojo.request.ShopDataAnchorRequest;
import com.myuserid.pojo.response.APIResponse;
import com.myuserid.pojo.response.ShopDataAnchorResponse;

import java.util.List;

/**
 * Coupon service
 * Created by Administrator on 2018/7/16.
 */
public interface IShopDataAnchorService {


    APIResponse<List<StShopDataAnchor>> getAnchorList();

    APIResponse<StShopDataAnchor> getById(int id);

    APIResponse<StShopDataAnchor> update(ShopDataAnchorRequest request);
}
