package com.bean.shell.controller;


import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bean.shell.entities.PurchaseData;
import com.bean.shell.entities.PurchaseDetail;
import com.bean.shell.entities.PurchaseInfo;
import com.bean.shell.entities.PurchaseList;
import com.bean.shell.service.IPurchaseInfoService;
import com.bean.shell.service.IPurchaseListService;
import com.bean.shell.util.ExcelUtil;
import com.bean.shell.util.HttpServerUtil;
import com.bean.shell.vo.PurchaseRequest;
import com.bean.shell.vo.SysAttrRequest;
import com.bean.shell.vo.SysAttrValueVO;
import com.xmTeam.cloud.entities.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.util.NumberUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
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
        String staffId = json.getStr("staffId");
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
                purchaseList.setCreateOper(staffId);
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
        String staffId =json.getStr("staffId");
        if(StrUtil.isNotEmpty(type) && "today".equals(type)){
            String date =  DateUtil.format(DateUtil.date(),"yyyy/MM/dd");
//        String date = json.getStr("orderDate");
            queryWrapper.eq("purchase_time",date);
        }
        // 只查询当前登录员工的信息
        if(StrUtil.isNotEmpty(staffId)){
            queryWrapper.eq("create_oper",staffId);
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

    /**
     * 后端表格查询
     * @param request
     * @param response
     * @returnqueryPurchaseList
     */
    @PostMapping(value = "/queryPurchaseList")
    public CommonResult queryPurchaseList(HttpServletRequest request, HttpServletResponse response){
        String reqBody = HttpServerUtil.reader(request, response);
        JSONObject json = new JSONObject(reqBody);
        CommonResult result = new CommonResult();
        PurchaseRequest purchaseRequest = new PurchaseRequest() ;
        String purchaseType =json.getStr("purchaseType");
        String subPurchaseType =json.getStr("subPurchaseType");
        String shopName =json.getStr("shopName");
        String page =json.getStr("page");
        String pageSize =json.getStr("pageSize");
        JSONArray dataArray = json.getJSONArray("purchaseDate");
        if(!CollectionUtils.isEmpty(dataArray)){
            String startDate = (String) dataArray.get(0);
            String endDate = (String) dataArray.get(1);
            if(StrUtil.isNotEmpty(startDate)){
                purchaseRequest.setPurchaseBeginTime(startDate);
            }
            if(StrUtil.isNotEmpty(endDate)){
                purchaseRequest.setPurchaseEndTime(endDate);
            }
        }
        if(StrUtil.isNotEmpty(purchaseType)){
            purchaseRequest.setParentType(purchaseType);
        }
        if(StrUtil.isNotEmpty(subPurchaseType)){
            purchaseRequest.setPurchaseType(subPurchaseType);
        }
        if(StrUtil.isNotEmpty(shopName)){
            purchaseRequest.setShopName(shopName);
        }
        CommonResult commonResult =  purchaseListService.queryPurchaseList(NumberUtil.parseLong(page), NumberUtil.parseLong(pageSize), purchaseRequest);

        return  commonResult ;
    }


    @PostMapping(value = "/deletePurchaseRow")
    public CommonResult deletePurchaseRow(HttpServletRequest request, HttpServletResponse response){
        String reqBody = HttpServerUtil.reader(request, response);
        JSONObject json = new JSONObject(reqBody);
        CommonResult result = new CommonResult();
        PurchaseRequest purchaseRequest = new PurchaseRequest() ;
        Long purchaseListId =json.getLong("purchaseListId");
        boolean delFlag = purchaseListService.removeById(purchaseListId);
        if(delFlag){
            return new CommonResult(200,"删除成功",delFlag);
        }else{
            return new CommonResult(400,"删除失败",delFlag);
        }
    }

    @PostMapping(value = "/updatePurchaseRow")
    public CommonResult updatePurchaseRow(HttpServletRequest request, HttpServletResponse response){
        String reqBody = HttpServerUtil.reader(request, response);
        JSONObject json = new JSONObject(reqBody);
        CommonResult result = new CommonResult();
        PurchaseRequest purchaseRequest = new PurchaseRequest() ;
        Long purchaseListId =json.getLong("purchaseListId");
        Float unitPrice =json.getFloat("unitPrice");
        Float purchaseNum =json.getFloat("purchaseNum");
        Float totalPrice =json.getFloat("totalPrice");
        String remark =json.getStr("remark");
        PurchaseList purchaseList = purchaseListService.getById(purchaseListId);
        purchaseList.setUnitPrice(unitPrice);
        purchaseList.setPurchaseNum(purchaseNum);
        purchaseList.setTotalPrice(totalPrice);
        purchaseList.setRemark(remark);
        boolean updateFlag =   purchaseListService.saveOrUpdate(purchaseList);
        if(updateFlag){
            return new CommonResult(200,"修改成功",updateFlag);
        }else{
            return new CommonResult(400,"修改失败",updateFlag);
        }
    }

    @GetMapping(value = "/export")
    public CommonResult export(HttpServletRequest request,HttpServletResponse response){
        request.getParameter("");
        PurchaseRequest   req = new PurchaseRequest();
//        CommonResult commonResult =  purchaseListService.queryPurchaseList(NumberUtil.parseLong(page), NumberUtil.parseLong(pageSize), purchaseRequest);
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
//        String fileName ="吴方元采购"+ DateUtil.format(DateUtil.date(),simpleDateFormat);
//        String sheetName="采购项";
//        try{
//            if(result != null){
//                ExcelUtil.writeExcel(response,(List<PurchaseData>)result.getData(),fileName,sheetName,new PurchaseData());
//            }
//        }catch (Exception e){
//            log.error("导出异常" + e.getMessage());
//        }
        return null ;
//        return restTemplate.getForObject(PAYMENT_URL+"/payment/getPaymentByName/"+name,CommonResult.class);
    }

}

