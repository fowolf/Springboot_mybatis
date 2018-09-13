package com.myuserid.pojo.dbentity;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by Administrator on 2018/7/13.
 * database city table
 */
@Getter
@Setter
public class CouponBatchInfo {
    private Integer id;
    private String batchcode;
    private String name;
    private Integer batchtype;
    private Integer batchstatus;
    private Integer count;
    private Integer amount;
    private Integer condition;
    private Date fromdate;
    private Date expireddate;
    private String remark;
    private Date createtime;
    private Date updatetime;
}
