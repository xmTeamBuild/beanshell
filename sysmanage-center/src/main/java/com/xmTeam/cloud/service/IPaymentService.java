package com.xmTeam.cloud.service;

import com.xmTeam.cloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface IPaymentService {

    Payment getPaymentByName(@Param("name") String name);

    int addPayment(Payment payment);
}
