package com.bean.shell.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bean.shell.entities.PurchaseInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bean.shell.vo.PurchaseRequest;
import com.bean.shell.vo.PurchaseVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 豆壳采购 Mapper 接口
 * </p>
 *
 * @author shenzq
 * @since 2020-11-30
 */
public interface PurchaseInfoMapper extends BaseMapper<PurchaseInfo> {

    IPage<PurchaseInfo> getPurchase(IPage<PurchaseInfo> page, @Param("req") PurchaseRequest req);

    List<PurchaseVO> getPurchase(@Param("req") PurchaseRequest req);

}
