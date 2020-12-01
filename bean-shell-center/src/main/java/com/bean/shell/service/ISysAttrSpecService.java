package com.bean.shell.service;

import com.bean.shell.entities.SysAttrSpec;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bean.shell.vo.SysAttrRequest;
import com.xmTeam.cloud.entities.CommonResult;

/**
 * <p>
 * 公共属性表 服务类
 * </p>
 *
 * @author shenzq
 * @since 2020-11-30
 */
public interface ISysAttrSpecService extends IService<SysAttrSpec> {

    CommonResult qryAttrValueList (SysAttrRequest req);

}
