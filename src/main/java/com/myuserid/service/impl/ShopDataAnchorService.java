package com.myuserid.service.impl;

import com.myuserid.dao.retailX.StShopDataAnchorMapper;
import com.myuserid.pojo.dbentity.StShopDataAnchor;
import com.myuserid.pojo.enums.StatusCode;
import com.myuserid.pojo.request.ShopDataAnchorRequest;
import com.myuserid.pojo.response.APIResponse;
import com.myuserid.service.IShopDataAnchorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * coupon service
 * Created by Administrator on 2018/7/16.
 */
@Service(value = "IShopDataAnchorService")
public class ShopDataAnchorService implements IShopDataAnchorService {

    private final StShopDataAnchorMapper stShopDataAnchorMapper;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    public ShopDataAnchorService(StShopDataAnchorMapper stShopDataAnchorMapper) {
        this.stShopDataAnchorMapper = stShopDataAnchorMapper;
    }

    @Override
    public APIResponse<List<StShopDataAnchor>> getAnchorList() {
        return new APIResponse<List<StShopDataAnchor>>().randerSucess(stShopDataAnchorMapper.findAll());
    }

    @Override
    public APIResponse<StShopDataAnchor> getById(int id) {
        return new APIResponse<StShopDataAnchor>().randerSucess(this.stShopDataAnchorMapper.getById(id));
    }

    @Override
    public APIResponse<StShopDataAnchor> update(ShopDataAnchorRequest request) {
        if ( request.getId() == 0) {
            return new APIResponse<StShopDataAnchor>().randerFail(StatusCode.ClientError, "Id is Empty");
        }

        StShopDataAnchor entity = this.stShopDataAnchorMapper.getById(request.getId());
        if (entity == null) {
            return new APIResponse<StShopDataAnchor>().randerFail(StatusCode.ClientError, "Id Not Exists");
        }

        entity.setDateLine(request.getDateLine());
        entity.setUpdateTime(new Date());

        this.stShopDataAnchorMapper.UpdateById(entity);
        return new APIResponse<StShopDataAnchor>().randerSucess(entity);
    }
}
