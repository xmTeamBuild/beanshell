package com.bean.shell.controller;


import cn.hutool.Hutool;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.util.DateUtils;
import com.bean.shell.entities.PurchaseData;
import com.bean.shell.entities.PurchaseDetail;
import com.bean.shell.entities.PurchaseInfo;
import com.bean.shell.service.IPurchaseDetailService;
import com.bean.shell.service.IPurchaseInfoService;
import com.bean.shell.util.ExcelUtil;
import com.bean.shell.util.HttpServerUtil;
import com.bean.shell.vo.PurchaseRequest;
import com.bean.shell.vo.PurchaseVO;
import com.bean.shell.vo.SysAttrRequest;
import com.xmTeam.cloud.entities.CommonResult;
import com.xmTeam.cloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.connector.Response;
import org.apache.velocity.runtime.directive.Foreach;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 豆壳采购 前端控制器
 * </p>
 *
 * @author shenzq
 * @since 2020-11-30
 */
@RestController
@RequestMapping("/purchaseInfo")
@Slf4j
public class PurchaseInfoController {
    @Resource
    private IPurchaseInfoService purchaseInfoService;

    @Resource
    private IPurchaseDetailService purchaseDetailService;

    @GetMapping(value = "/purchase/getPurchaseName/{page}/{size}")
    public CommonResult getPurchaseByName( @PathVariable("page") long page,
                                           @PathVariable("size") long size,
                                           @RequestBody(required = false)  PurchaseRequest   req){
        CommonResult result = purchaseInfoService.getPurchase(1L,5L,req);
        return  result ;
    }

    @GetMapping("export")
    public void export(HttpServletResponse response){
        PurchaseRequest   req = new PurchaseRequest();
        CommonResult result = purchaseInfoService.getPurchase(req);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        String fileName ="吴方元采购"+ DateUtil.format(DateUtil.date(),simpleDateFormat);
        String sheetName="采购项";
        try{
            if(result != null){
                ExcelUtil.writeExcel(response,(List<PurchaseData>)result.getData(),fileName,sheetName,new PurchaseData());
            }
        }catch (Exception e){
           log.error("导出异常" + e.getMessage());
        }
    }



}

