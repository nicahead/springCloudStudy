package me.nic.cloud.controller;

import me.nic.cloud.dto.CommonResult;
import me.nic.cloud.entities.Payment;
import me.nic.cloud.service.RemotePaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {

    @Autowired
    private RemotePaymentService remotePaymentService;

    @GetMapping("/consumer/get/payment/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Long id) {
        CommonResult<Payment> paymentById = remotePaymentService.get(id);
        return paymentById;
    }
}
