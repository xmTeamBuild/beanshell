package com.bean.shell.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bean.shell.entities.PurchaseInfo;
import com.bean.shell.entities.PurchaseList;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bean.shell.vo.PurchaseRequest;
import com.bean.shell.vo.PurchaseVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 豆壳采购数据列表 Mapper 接口
 * </p>
 *
 * @author shenzq
 * @since 2020-12-13
 */
public interface PurchaseListMapper extends BaseMapper<PurchaseList> {

    IPage<PurchaseInfo> queryPurchaseList(IPage<PurchaseInfo> page, @Param("req") PurchaseRequest req);

}
