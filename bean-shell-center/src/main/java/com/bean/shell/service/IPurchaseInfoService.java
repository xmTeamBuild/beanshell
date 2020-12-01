package com.bean.shell.service;

import com.bean.shell.entities.PurchaseData;
import com.bean.shell.entities.PurchaseInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bean.shell.vo.PurchaseRequest;
import com.bean.shell.vo.PurchaseVO;
import com.xmTeam.cloud.entities.CommonResult;

import javax.xml.transform.Result;
import java.util.List;

/**
 * <p>
 * 豆壳采购 服务类
 * </p>
 *
 * @author shenzq
 * @since 2020-11-30
 */
public interface IPurchaseInfoService extends IService<PurchaseInfo> {

    CommonResult getPurchase (Long page, Long size, PurchaseRequest req);

    CommonResult getPurchase (PurchaseRequest req);

}
