package com.bean.shell.controller;


import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bean.shell.entities.BeanshellStaff;
import com.bean.shell.entities.PurchaseList;
import com.bean.shell.service.IBeanshellStaffService;
import com.bean.shell.service.IPurchaseListService;
import com.bean.shell.util.HttpServerUtil;
import com.xmTeam.cloud.entities.CommonResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>
 * 员工表 前端控制器
 * </p>
 *
 * @author shenzq
 * @since 2020-12-13
 */
@RestController
@RequestMapping("/beanshellStaff")
public class BeanshellStaffController {
    @Resource
    private IBeanshellStaffService beanshellStaffService;

    @PostMapping(value = "/qryStaff")
    public CommonResult qryStaff(HttpServletRequest request, HttpServletResponse response){
        String reqBody = HttpServerUtil.reader(request, response);
        JSONObject json = new JSONObject(reqBody);
        QueryWrapper<BeanshellStaff> queryWrapper = new QueryWrapper<>();
        String staffName = json.getStr("account");
        String pwd = json.getStr("pwd");
        queryWrapper.eq("STAFF_NAME",staffName);
        queryWrapper.eq("STAFF_PWD",pwd);
        List<BeanshellStaff> beanshellStaffList =  beanshellStaffService.list(queryWrapper);
        CommonResult result  = new CommonResult(200,"",beanshellStaffList);;
        return  result ;
    }

}

