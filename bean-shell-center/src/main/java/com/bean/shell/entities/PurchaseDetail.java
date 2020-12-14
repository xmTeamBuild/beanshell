package com.bean.shell.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 采购详情
 * </p>
 *
 * @author shenzq
 * @since 2020-12-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PurchaseDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "purchase_detail_id", type = IdType.AUTO)
    private Long purchaseDetailId;

    private Long purchaseInfoId;

    /**
     * 单价
     */
    private Float purchaseUnitPrice;

    /**
     * 数量
     */
    private Float puchaseNumber;

    /**
     * 总价
     */
    private Float puchaseTotalPrice;

    /**
     * 下单时间
     */
    private LocalDate orderTime;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 更新时间
     */
    private Long createOper;

    /**
     * 创建人员
     */
    private String updateTime;

    /**
     * 更新人员
     */
    private Long updateOper;

    /**
     * 状态
     */
    private Long status;

    /**
     * 备注
     */
    private String remark;


}
