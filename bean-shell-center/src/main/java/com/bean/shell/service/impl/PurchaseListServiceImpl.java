package com.bean.shell.service.impl;

import com.bean.shell.entities.PurchaseList;
import com.bean.shell.dao.PurchaseListMapper;
import com.bean.shell.service.IPurchaseListService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
