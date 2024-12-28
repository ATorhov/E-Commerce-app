package com.torhoff.ecommerce.order;

import com.torhoff.ecommerce.customer.CustomerClient;
import com.torhoff.ecommerce.exception.BusinessException;
import com.torhoff.ecommerce.orderline.OrderLine;
import com.torhoff.ecommerce.orderline.OrderLineRequest;
import com.torhoff.ecommerce.orderline.OrderLineService;
import com.torhoff.ecommerce.product.ProductClient;
import com.torhoff.ecommerce.product.PurchaseRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repository;
    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final OrderMapper mapper;
    private final OrderLineService orderLineService;

    public Integer createOrder(OrderRequest request) {
        var customer = this.customerClient.findCustomerById(request.customerId())
                .orElseThrow(() -> new BusinessException("Cannot create order:: No customer exists with the provided ID"));

        this.productClient.purchaseProducts(request.products());

        var order = this.repository.save(mapper.toOrder(request));

        for (PurchaseRequest purchaseRequest : request.products()) {
            orderLineService.saveOrderLine(
                    new OrderLineRequest(
                            null,
                            order.getId(),
                            purchaseRequest.productId(),
                            purchaseRequest.quantity()
                    )
            );
        }


        return null;
    }
}
