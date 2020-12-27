package com.bean.shell.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bean.shell.dao.PurchaseInfoMapper;
import com.bean.shell.entities.PurchaseData;
import com.bean.shell.entities.PurchaseInfo;
import com.bean.shell.entities.PurchaseList;
import com.bean.shell.dao.PurchaseListMapper;
import com.bean.shell.service.IPurchaseListService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bean.shell.vo.PurchaseRequest;
import com.bean.shell.vo.PurchaseVO;
import com.xmTeam.cloud.entities.CommonResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 豆壳采购数据列表 服务实现类
 * </p>
 *
 * @author shenzq
 * @since 2020-12-13
 */
@Service
public class PurchaseListServiceImpl extends ServiceImpl<PurchaseListMapper, PurchaseList> implements IPurchaseListService {

    @Resource
    private PurchaseListMapper purchaseListMapper;

   public CommonResult queryPurchaseList (Long page, Long size, PurchaseRequest req){
       /**
        *因为mapper.xml已经对查询条件进行筛选和拼接了
        */
       if (req==null){
           req=new PurchaseRequest();
       }
       List<PurchaseData> purchaseDataList = new ArrayList<>();

       IPage<PurchaseInfo> data = purchaseListMapper.queryPurchaseList(new Page<>(page, size),req);

       return new CommonResult(200,"查询purchase数据成功",data);
   }

}
