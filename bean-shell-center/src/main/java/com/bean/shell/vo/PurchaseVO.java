package com.bean.shell.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class PurchaseVO implements Serializable {

    private static final long serialVersionUID = 3230137778441396518L;

    private Long purchaseListId;

    /**
     * 采购类型
     */
    private String parentType;

    /**
     * 品名
     */
    private String parentName;
    /**
     * 品名类型
     */
    private String purchaseType;

    /**
     * 品名
     */
    private String purchaseName;

    /**
     * 数量
     */
    private Float purchaseNum;

    /**
     * 规格
     */
    private String purchaseSpec;

    /**
     * 下单时间
     */
    private String purchaseTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 创建员工
     */
    private String createOper;

    /**
     * 更新时间
     */
    private String updateTime;

    /**
     * 更新员工
     */
    private String updateOper;

    /**
     * 状态
     */
    private Long status;
    /**
     * 员工名称
     */
    private String staffName;
    /**
     * 下单来源店
     */
    private String shopAddr;

    /**
     * 单价
     */
    private Float unitPrice;
    /**
     * 总价
     */
    private Float totalPrice;
}
