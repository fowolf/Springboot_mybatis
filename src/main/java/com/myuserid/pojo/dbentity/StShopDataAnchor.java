package com.myuserid.pojo.dbentity;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by Administrator on 2018/7/13.
 * database city table
 */
@Setter
@Getter
public class StShopDataAnchor {
    private Integer id;
    private String shopId;
    private String shopNo;
    private Date dateLine;
    private Date createTime;
    private Date updateTime;
}
