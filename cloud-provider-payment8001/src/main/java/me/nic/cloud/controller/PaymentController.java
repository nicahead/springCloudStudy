package me.nic.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import me.nic.cloud.dto.CommonResult;
import me.nic.cloud.entities.Payment;
import me.nic.cloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Long id) {
        Payment paymentById = paymentService.getPaymentById(id);
        return new CommonResult<>(200, "查询成功 server port:" + serverPort, paymentById);
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

    @GetMapping("/payment/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("----------element:" + service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info("serviceId:[{}], 主机名称:[{}], 端口号:[{}], url地址:[{}]", instance.getServiceId(), instance.getHost(), instance.getPort(), instance.getUri());
        }
        return this.discoveryClient;
    }

    @RequestMapping("/get/lb")
    public String getLBid(){
        return serverPort;
    }
}
