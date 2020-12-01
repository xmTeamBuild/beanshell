package com.bean.shell.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bean.shell.entities.PurchaseData;
import com.bean.shell.entities.PurchaseInfo;
import com.bean.shell.dao.PurchaseInfoMapper;
import com.bean.shell.service.IPurchaseInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bean.shell.vo.PurchaseRequest;
import com.bean.shell.vo.PurchaseVO;
import com.xmTeam.cloud.entities.CommonResult;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 豆壳采购 服务实现类
 * </p>
 *
 * @author shenzq
 * @since 2020-11-30
 */
@Service
public class PurchaseInfoServiceImpl extends ServiceImpl<PurchaseInfoMapper, PurchaseInfo> implements IPurchaseInfoService {

    @Resource
    private PurchaseInfoMapper purchaseInfoMapper;

    public CommonResult getPurchase (Long page, Long size, PurchaseRequest req){
        /**
         *因为mapper.xml已经对查询条件进行筛选和拼接了
         */
        if (req==null){
            req=new PurchaseRequest();
        }
        IPage data = purchaseInfoMapper.getPurchase(new Page<>(page, size), req);
        return new CommonResult(200,"查询purchase数据成功",data);
    }

    public CommonResult getPurchase (PurchaseRequest req){
        /**
         *因为mapper.xml已经对查询条件进行筛选和拼接了
         */
        if (req==null){
            req=new PurchaseRequest();
        }
        List<PurchaseData> purchaseDataList = new ArrayList<>();
        List<PurchaseVO>  data = purchaseInfoMapper.getPurchase(req);
        if(!CollectionUtils.isEmpty(data)){
            for (PurchaseVO purchaseVO: data) {
                PurchaseData purchaseData = new PurchaseData();
                BeanUtil.copyProperties(purchaseData,purchaseVO);
                purchaseDataList.add(purchaseData);
            }
        }
//        if(result != null){
//            List<PurchaseVO> purchaseVOList = (List<PurchaseVO>)result.getData();
//            if(!CollectionUtils.isEmpty(purchaseVOList)){
//                for (PurchaseVO purchaseVO: purchaseVOList) {
//                    PurchaseData purchaseData = new PurchaseData();
//                    purchaseData.setPurchaseName(purchaseVO.getPurchaseName());
//                    purchaseData.setPurchaseType(purchaseVO.getPurchaseType());
//                    purchaseData.setPurchaseUnit(StrUtil.toString(purchaseVO.getPurchaseUnit()));
//                    purchaseData.setRemark(purchaseVO.getRemark());
//                    purchaseData.setPurchaseUnitPrice(purchaseVO.getPurchaseUnitPrice());
//                    purchaseData.setPuchaseNumber(purchaseVO.getPuchaseNumber());
//                    purchaseData.setPuchaseTotalPrice(purchaseVO.getPuchaseTotalPrice());
//                    purchaseData.setOrderTime(DateUtil.format(DateUtil.date(),simpleDateFormat));
//                    purchaseDataList.add(purchaseData);
//                }
//            }
//
//        }
        return new CommonResult(200,"查询purchase数据成功",purchaseDataList);
    }



}
