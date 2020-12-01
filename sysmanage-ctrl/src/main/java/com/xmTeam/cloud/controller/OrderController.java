package com.xmTeam.cloud.controller;

import com.xmTeam.cloud.config.ApplicationContextConfig;
import com.xmTeam.cloud.entities.CommonResult;
import com.xmTeam.cloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {
    @Resource
    private RestTemplate restTemplate ;

    public static final String PAYMENT_URL="http://localhost:8001";

    @GetMapping(value = "/consume/getPaymentByName/{name}")
    public CommonResult getPaymentByName(@PathVariable("name") String name){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/getPaymentByName/"+name,CommonResult.class);
    }

    @PostMapping(value = "/consume/addPayment")
    public CommonResult<Payment> addPayment(Payment payment){
       return restTemplate.postForObject(PAYMENT_URL+"/payment/addPayment",payment,CommonResult.class);
    }
}
