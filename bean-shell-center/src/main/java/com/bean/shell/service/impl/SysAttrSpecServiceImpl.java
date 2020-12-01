package com.bean.shell.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bean.shell.dao.PurchaseInfoMapper;
import com.bean.shell.entities.SysAttrSpec;
import com.bean.shell.dao.SysAttrSpecMapper;
import com.bean.shell.service.ISysAttrSpecService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bean.shell.vo.PurchaseRequest;
import com.bean.shell.vo.SysAttrRequest;
import com.bean.shell.vo.SysAttrValueVO;
import com.xmTeam.cloud.entities.CommonResult;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 公共属性表 服务实现类
 * </p>
 *
 * @author shenzq
 * @since 2020-11-30
 */
@Service
public class SysAttrSpecServiceImpl extends ServiceImpl<SysAttrSpecMapper, SysAttrSpec> implements ISysAttrSpecService {
    @Resource
    private SysAttrSpecMapper sysAttrSpecMapper;

    public CommonResult qryAttrValueList (SysAttrRequest req){
        /**
         *因为mapper.xml已经对查询条件进行筛选和拼接了
         */
        if (req==null){
            req=new SysAttrRequest();
        }
        List<SysAttrValueVO> data = sysAttrSpecMapper.qryAttrValueList(req);
        Map<String, List<SysAttrValueVO>> collect = new HashMap<>();
        if(!CollectionUtils.isEmpty(data)){
            collect =  data.stream().collect(Collectors.groupingBy(SysAttrValueVO::getAttrSpecCode));
        }
        return new CommonResult(200,"查询Attrvalue数据成功",collect);
    }
}
