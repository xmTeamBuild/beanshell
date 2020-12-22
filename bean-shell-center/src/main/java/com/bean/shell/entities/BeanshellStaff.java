package com.bean.shell.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 员工表
 * </p>
 *
 * @author shenzq
 * @since 2020-12-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BeanshellStaff implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "beanshell_staff_id", type = IdType.AUTO)
    private Long beanshellStaffId;

    /**
     * 员工名称
     */
    private String staffName;

    /**
     * 密码
     */
    private String staffPwd;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 状态
     */
    private String status;


}
