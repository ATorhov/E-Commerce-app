package com.torhoff.ecommerce.orderline;

import com.torhoff.ecommerce.order.Order;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class OrderLine {

    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "order-id")
    private Order order;
    private Integer productId;
    private Double quantity;
}
