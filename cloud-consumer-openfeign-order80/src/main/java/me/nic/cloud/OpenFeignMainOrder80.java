package me.nic.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients  // 启用Feign功能
public class OpenFeignMainOrder80 {
    public static void main(String[] args) {
        SpringApplication.run(OpenFeignMainOrder80.class,args);
    }
}
