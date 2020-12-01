package com.bean.shell.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 公共属性表
 * </p>
 *
 * @author shenzq
 * @since 2020-11-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysAttrSpec implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "attr_spec_id", type = IdType.AUTO)
    private Long attrSpecId;

    private String attrSpecCode;

    private String attrSpecValue;

    private String attrSpecDesc;

    private LocalDate createTime;

    private LocalDate updateTime;


}
