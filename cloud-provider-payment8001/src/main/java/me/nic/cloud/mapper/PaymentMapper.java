package me.nic.cloud.mapper;

import me.nic.cloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentMapper {

    int create(Payment payment);

    Payment selectPaymentById(Long id);

}
