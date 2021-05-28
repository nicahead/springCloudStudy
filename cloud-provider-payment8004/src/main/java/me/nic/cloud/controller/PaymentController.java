package me.nic.cloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @GetMapping("/payment/zktest")
    public String zktest() {
        return "zk is ok";
    }

}
