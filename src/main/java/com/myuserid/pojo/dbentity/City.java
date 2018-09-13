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
public class City {
    private Integer id;
    private String name;
    private Boolean isProvince;
    private Integer parentId;
    private Integer status;
    private Date updateDate;
    private String zipCode;
    private boolean isCity;
}
