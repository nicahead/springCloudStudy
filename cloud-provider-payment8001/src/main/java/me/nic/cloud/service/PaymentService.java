package me.nic.cloud.service;

import me.nic.cloud.entities.Payment;

public interface PaymentService {
    int save(Payment payment);

    Payment getPaymentById(Long id);
}
