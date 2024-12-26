package com.torhoff.ecommerce.category;

import com.torhoff.ecommerce.product.Product;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Getter
@Setter
@Entity
public class Category {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "category", cascade = CascadeType.REMOVE)
    private List<Product> products;

}
