package com.bean.shell.vo;

import lombok.Data;

import java.util.Date;

@Data
public class PurchaseRequest {
    /**
     * 采购类型
     */
    private String parentType;

    /**
     * 采购品名
     */
    private String purchaseType;
    /**
     * 采购店
     */
    private String shopName;
    /**
     * 下单开始时间
     */
    private String purchaseBeginTime;
    /**
     * 下单结束时间
     */
    private String purchaseEndTime;

    /**
     * 品名
     */
    private String purchaseName;
    /**
     * 规格
     */
    private Long purchaseUnit;
    /**
     * 备注
     */
    private String remark;
    /**
     * 单价
     */
    private String purchaseUnitPrice;
    /**
     * 下单时间
     */
    private Date orderTime;
    /**
     * 创建时间
     */
    private Date create_time;
    /**
     * 状态
     */
    private Long status;
}
