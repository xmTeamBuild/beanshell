package com.bean.shell.vo;

import java.util.Date;

public class PurchaseRequest {
    /**
     * 采购类型
     */
    private Long purchaseType;

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
