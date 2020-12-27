package com.bean.shell.service;

import com.bean.shell.entities.PurchaseList;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bean.shell.vo.PurchaseRequest;
import com.xmTeam.cloud.entities.CommonResult;

/**
 * <p>
 * 豆壳采购数据列表 服务类
 * </p>
 *
 * @author shenzq
 * @since 2020-12-13
 */
public interface IPurchaseListService extends IService<PurchaseList> {

    CommonResult queryPurchaseList (Long page, Long size, PurchaseRequest req);

}
