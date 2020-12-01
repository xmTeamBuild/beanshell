package com.xmTeam.cloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;

/**
 * <p>
 * 豆壳餐厅采购支付信息
 * </p>
 *
 * @author shenzq
 * @since 2020-11-29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {

    private static final long serialVersionUID=1L;

    private Long paymentId;

    /**
     * 支付类型
     */
    private Long paymentType;

    /**
     * 支付名称
     */
    private String paymentName;

    /**
     * 单价
     */
    private String unitPrice;

    /**
     * 购买数量
     */
    private String paymentNumber;

    /**
     * 总价
     */
    private Float totalPrice;

    /**
     * 购买日期
     */
    private Date paymentTime;

    /**
     * 店家名称
     */
    private String shopName;

    /**
     * 店家地址
     */
    private String shopAddr;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建日期
     */
    private Date createTime;

    /**
     * 更新日期
     */
    private Date updateTime;

    /**
     * 创建员工
     */
    private Long createOperId;

    /**
     * 更新员工
     */
    private Long updateOperId;

    /**
     * 状态
     */
    private String status;


}
