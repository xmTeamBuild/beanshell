package com.bean.shell.dao;

import com.bean.shell.entities.SysAttrSpec;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bean.shell.vo.SysAttrRequest;
import com.bean.shell.vo.SysAttrValueVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 公共属性表 Mapper 接口
 * </p>
 *
 * @author shenzq
 * @since 2020-11-30
 */
public interface SysAttrSpecMapper extends BaseMapper<SysAttrSpec> {

    List<SysAttrValueVO> qryAttrValueList(@Param("req") SysAttrRequest req);


}
