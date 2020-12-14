package com.bean.shell.controller;


import cn.hutool.core.util.StrUtil;
import com.bean.shell.entities.SysAttrSpec;
import com.bean.shell.service.IPurchaseInfoService;
import com.bean.shell.service.ISysAttrSpecService;
import com.bean.shell.vo.PurchaseRequest;
import com.bean.shell.vo.SysAttrRequest;
import com.xmTeam.cloud.entities.CommonResult;
import com.xmTeam.cloud.entities.Payment;
import org.omg.CORBA.Request;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 公共属性表 前端控制器
 * </p>
 *
 * @author shenzq
 * @since 2020-11-30
 */
@RestController
@RequestMapping("/sys")
public class SysAttrSpecController {

    @Resource
    private ISysAttrSpecService sysAttrSpecService;

    @GetMapping(value = "/qryAttrValueList/{specCode}")
    public CommonResult qryAttrValueList(@PathVariable("specCode") String specCode){
        SysAttrRequest req = new SysAttrRequest();
//        req.setAttrSpecCode(specCode);
        CommonResult result = sysAttrSpecService.qryAttrValueList(req);
        return  result ;
    }

    @PostMapping(value = "/qryAttrValueArray")
    public CommonResult addPayment(@RequestBody SysAttrRequest request){
        CommonResult result = sysAttrSpecService.qryAttrValueList(request);
        return  result ;
    }

    @PostMapping(value = "/getAttrSpecList")
    public CommonResult getAttrSpecList(@RequestBody SysAttrRequest request){
        SysAttrRequest req = new SysAttrRequest();
        List<SysAttrSpec> sysAttrSpecList =  sysAttrSpecService.list();
        return new CommonResult(200,"查询getAttrSpecList数据成功",sysAttrSpecList);
    }
}

