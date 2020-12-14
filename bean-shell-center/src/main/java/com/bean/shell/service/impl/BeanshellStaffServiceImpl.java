package com.bean.shell.service.impl;

import com.bean.shell.entities.BeanshellStaff;
import com.bean.shell.dao.BeanshellStaffMapper;
import com.bean.shell.service.IBeanshellStaffService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 员工表 服务实现类
 * </p>
 *
 * @author shenzq
 * @since 2020-12-13
 */
@Service
public class BeanshellStaffServiceImpl extends ServiceImpl<BeanshellStaffMapper, BeanshellStaff> implements IBeanshellStaffService {

}
