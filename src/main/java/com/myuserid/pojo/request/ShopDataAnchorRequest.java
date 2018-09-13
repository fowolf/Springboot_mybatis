package com.myuserid.pojo.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * ShopDataAnchor Response
 * Created by Administrator on 2018/9/12.
 */
@Getter
@Setter
public class ShopDataAnchorRequest {
    private Integer id;
    private String shopId;
    private String shopNo;
    private Date dateLine;
    private Date createTime;
    private Date updateTime;
}
