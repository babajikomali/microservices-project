package com.babajikomali.order_service.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "t_order_line_items")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineItems {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;
}
