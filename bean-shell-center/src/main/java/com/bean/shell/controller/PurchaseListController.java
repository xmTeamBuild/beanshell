package com.bean.shell.controller;


import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bean.shell.entities.PurchaseDetail;
import com.bean.shell.entities.PurchaseInfo;
import com.bean.shell.entities.PurchaseList;
import com.bean.shell.service.IPurchaseInfoService;
import com.bean.shell.service.IPurchaseListService;
import com.bean.shell.util.HttpServerUtil;
import com.bean.shell.vo.PurchaseRequest;
import com.bean.shell.vo.SysAttrRequest;
import com.bean.shell.vo.SysAttrValueVO;
import com.xmTeam.cloud.entities.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>
 * 豆壳采购数据列表 前端控制器
 * </p>
 *
 * @author shenzq
 * @since 2020-12-13
 */
@RestController
@RequestMapping("/purchaseList")
@Slf4j
public class PurchaseListController {
    @Resource
    private IPurchaseListService purchaseListService;

    @PostMapping(value = "/addOrder")
    public CommonResult addOrder(HttpServletRequest request, HttpServletResponse response){
        String reqBody = HttpServerUtil.reader(request, response);
        JSONObject json = new JSONObject(reqBody);
        JSONArray jsonArray = json.getJSONArray("purchaseList");
        List<PurchaseList> purchaseListList = new ArrayList<>();
        String now = DateUtil.now();
        if(!CollectionUtils.isEmpty(jsonArray)){
            for (JSONObject jsonObj : jsonArray.jsonIter()) {
                PurchaseList purchaseList = new PurchaseList();
                purchaseList.setParentName(jsonObj.getStr("parentName"));
                purchaseList.setParentType(jsonObj.getStr("attrSpecId"));
                purchaseList.setPurchaseNum(jsonObj.getFloat("activeNum"));
                purchaseList.setPurchaseType(jsonObj.getStr("attrValue"));
                purchaseList.setPurchaseName(jsonObj.getStr("attrName"));
                purchaseList.setPurchaseSpec(jsonObj.getStr("attrDesc"));
                purchaseList.setStatus(1L);
                purchaseList.setCreateTime(now);
                purchaseList.setPurchaseTime(now);
                purchaseList.setUpdateTime(now);
                purchaseListList.add(purchaseList);
            }
        }
        boolean saveFlag =  purchaseListService.saveBatch(purchaseListList);
        CommonResult result ;
        if(saveFlag){
            result =  new CommonResult(200,"下单成功",saveFlag);
        }else{
            result =  new CommonResult(444,"下单失败",saveFlag);
        }
        return  result ;
    }


    @PostMapping(value = "/getOrderListByDate")
    public CommonResult getOrderListByDate(HttpServletRequest request, HttpServletResponse response){
        String reqBody = HttpServerUtil.reader(request, response);
        JSONObject json = new JSONObject(reqBody);
        CommonResult result = new CommonResult();
        QueryWrapper<PurchaseList> queryWrapper = new QueryWrapper<>();
        // 定义今日还是历史
        String type =json.getStr("orderType");
        if(StrUtil.isNotEmpty(type) && "today".equals(type)){
            String date =  DateUtil.format(DateUtil.date(),"yyyy/MM/dd");
//        String date = json.getStr("orderDate");
            queryWrapper.eq("purchase_time",date);
        }
        queryWrapper.orderByDesc("PURCHASE_TIME");
        List<PurchaseList> purchaseLists =  purchaseListService.list(queryWrapper);
        if(StrUtil.isNotEmpty(type) && "today".equals(type)){
             result  = new CommonResult(200,"",purchaseLists);;
        }else{
            Map<String, List<PurchaseList>> collect = new HashMap<>();
            if(!CollectionUtils.isEmpty(purchaseLists)){
                collect =  purchaseLists.stream().collect(Collectors.groupingBy(PurchaseList::getPurchaseTime, LinkedHashMap::new,Collectors.toList()));
            }
            return new CommonResult(200,"查询历史订单成功",collect);
        }
        return  result ;
    }
}

