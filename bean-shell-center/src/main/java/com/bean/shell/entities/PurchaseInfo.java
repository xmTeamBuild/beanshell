package com.bean.shell.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 豆壳采购
 * </p>
 *
 * @author shenzq
 * @since 2020-11-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PurchaseInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "purchase_info_id", type = IdType.AUTO)
    private Long purchaseInfoId;

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
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人员
     */
    private Long createOper;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 修改人员
     */
    private Long updateOper;

    /**
     * 状态
     */
    private Long status;


}
