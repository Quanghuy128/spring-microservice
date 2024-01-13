package com.microservice.orderservice.dto;

import com.microservice.orderservice.model.OrderLineItem;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
    private UUID id;
    private String orderNumber;
    private List<OrderLineItem> orderLineItemList;
}
