package com.torhoff.ecommerce.payment;

import com.torhoff.ecommerce.customer.CustomerResponse;
import com.torhoff.ecommerce.order.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(

        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        CustomerResponse customer
) {
}
