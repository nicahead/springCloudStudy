package me.nic.cloud.controller;

import lombok.val;
import me.nic.cloud.dto.CommonResult;
import me.nic.cloud.entities.Payment;
import me.nic.cloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Long id) {
        Payment paymentById = paymentService.getPaymentById(id);
        return new CommonResult<>(200, "查询成功", paymentById);
    }

    @PostMapping("/payment/save")
    public CommonResult<Payment> save(@RequestBody Payment payment) {
        int save = paymentService.save(payment);
        if (save > 0) {
            return new CommonResult<>(201, "插入成功");
        } else {
            return new CommonResult<>(501, "插入失败");
        }
    }
}
