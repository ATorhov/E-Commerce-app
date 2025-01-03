package com.torhoff.ecommerce.kafka.order;

import java.math.BigDecimal;

public record Product(
        Integer id,
        String name,
        String description,
        BigDecimal price,
        Double quantity
) {
}