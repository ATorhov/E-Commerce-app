package com.torhoff.ecommerce.order;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.List;

import com.torhoff.ecommerce.product.PurchaseRequest;

public record OrderRequest(
        Integer id,

        String reference,

        @Positive(message = "Order amount should be positive!")
        BigDecimal totalAmount,

        @NotNull(message = "Payment method should be precised")
        PaymentMethod paymentMethod,

        @NotNull(message = "Customer should be present")
        @NotEmpty(message = "Customer should be present")
        @NotBlank(message = "Customer should be present")
        String customerId,

        @NotEmpty(message = "Products should be present")
        List<PurchaseRequest> products

) {
}
