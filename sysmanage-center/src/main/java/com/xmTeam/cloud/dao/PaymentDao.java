package com.xmTeam.cloud.dao;


import com.xmTeam.cloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PaymentDao {

    Payment getPaymentByName(@Param("paymentName") String paymentName);

    int addPayment(Payment payment);

}
