package com.torhoff.ecommerce.product;

import com.torhoff.ecommerce.category.Category;

import java.math.BigDecimal;

public record ProductResponse(
        Integer id,
        String name,
        String description,
        Double availableQuantity,
        BigDecimal price,
        Integer categoryId,
        String categoryName,
        String categoryDescription
) {
}
