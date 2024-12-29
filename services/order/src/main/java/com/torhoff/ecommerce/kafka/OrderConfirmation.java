package com.torhoff.ecommerce.kafka;

import com.torhoff.ecommerce.customer.CustomerResponse;
import com.torhoff.ecommerce.order.PaymentMethod;
import com.torhoff.ecommerce.product.PurchaseResponse;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        CustomerResponse customer,
        List<PurchaseResponse> products
) {
}
