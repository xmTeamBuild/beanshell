package com.xmTeam.cloud.service.impl;

import com.xmTeam.cloud.dao.PaymentDao;
import com.xmTeam.cloud.entities.Payment;
import com.xmTeam.cloud.service.IPaymentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements IPaymentService {

    @Resource
    private PaymentDao paymentDao;

    public Payment getPaymentByName(String paymentName){
        return  paymentDao.getPaymentByName(paymentName);
    }

    public int addPayment(Payment payment){
        return paymentDao.addPayment(payment);
    }
}
