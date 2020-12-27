package com.bean.shell.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 豆壳采购数据列表
 * </p>
 *
 * @author shenzq
 * @since 2020-12-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PurchaseList implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "purchase_list_id", type = IdType.AUTO)
    private Long purchaseListId;

    /**
     * 采购类
     */
    private String parentType;

    /**
     * 采购类名称
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
     * 单价
     */
    private Float unitPrice;
    /**
     * 总价
     */
    private Float totalPrice;


}
