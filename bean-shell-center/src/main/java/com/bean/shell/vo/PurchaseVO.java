package com.bean.shell.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class PurchaseVO implements Serializable {

    private static final long serialVersionUID = 3230137778441396518L;

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
     * 数量
     */
    private String puchaseNumber;
    /**
     * 总价
     */
    private String puchaseTotalPrice;
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
