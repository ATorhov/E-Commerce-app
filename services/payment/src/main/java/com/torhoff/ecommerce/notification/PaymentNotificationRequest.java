package com.torhoff.ecommerce.notification;

import com.torhoff.ecommerce.payment.PaymentMethod;

import java.math.BigDecimal;

public record PaymentNotificationRequest(
        String orderReference,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        String customerFirstName,
        String customerLastName,
        String customerEmail
) {
}
