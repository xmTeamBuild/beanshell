package com.xmTeam.cloud.controller;

import com.xmTeam.cloud.entities.CommonResult;
import com.xmTeam.cloud.entities.Payment;
import com.xmTeam.cloud.service.IPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private IPaymentService paymentService;

    @PostMapping(value = "/payment/addPayment")
    public CommonResult addPayment(@RequestBody Payment payment){
      int result = paymentService.addPayment(payment);
      log.info("****插入payment的结果："+result);
      if(result > 0){
          return new CommonResult(200,"插入payment数据成功",result);
      }else{
          return new CommonResult(444,"插入payment数据失败",null);
      }
    }


    @GetMapping(value = "/payment/getPaymentByName/{name}")
    public CommonResult getPaymentByName(@PathVariable("name") String name){
        Payment payment = paymentService.getPaymentByName(name);
        log.info("****查询payment的结果："+payment);
        if(payment != null){
            return new CommonResult(200,"查询payment数据成功",payment);
        }else{
            return new CommonResult(444,"查询payment数据失败",null);
        }
    }
}
