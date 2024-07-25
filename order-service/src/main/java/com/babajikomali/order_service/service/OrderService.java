package com.babajikomali.order_service.service;

import com.babajikomali.order_service.dto.OrderRequest;
import com.babajikomali.order_service.model.Order;
import com.babajikomali.order_service.model.OrderLineItems;
import com.babajikomali.order_service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        List<OrderLineItems> orderLineItemsList = orderRequest.getOrderLineItemsDtoList()
                .stream()
                .map(orderLineItemsDto -> OrderLineItems.builder()
                        .price(orderLineItemsDto.getPrice())
                        .quantity(orderLineItemsDto.getQuantity())
                        .skuCode(orderLineItemsDto.getSkuCode())
                        .build())
                .toList();
        order.setOrderLineItemsList(orderLineItemsList);
        orderRepository.save(order);
    }
}
