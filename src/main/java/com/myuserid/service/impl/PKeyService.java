package com.myuserid.service.impl;

import com.myuserid.dao.retailX.ProductKeyMapper;
import com.myuserid.pojo.dbentity.retailX.PKey;
import com.myuserid.service.IPKeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * coupon service
 * Created by Administrator on 2018/7/16.
 */
@Service
public class PKeyService implements IPKeyService {

    private final ProductKeyMapper productKeyMapper;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    public PKeyService(ProductKeyMapper productKeyMapper) {
        this.productKeyMapper = productKeyMapper;
    }

    @Override
    public PKey getKeyByChannel(String channel) {
        return this.productKeyMapper.getKeyByChannel(channel);
    }
}
