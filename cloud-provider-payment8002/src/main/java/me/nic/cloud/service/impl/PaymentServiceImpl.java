package me.nic.cloud.service.impl;

import me.nic.cloud.entities.Payment;
import me.nic.cloud.mapper.PaymentMapper;
import me.nic.cloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentMapper paymentMapper;

    @Override
    public int save(Payment payment) {
        return paymentMapper.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentMapper.selectPaymentById(id);
    }
}
