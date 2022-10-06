package com.itmaspro.general.domain.model.dto;


import java.util.Set;

import com.itmaspro.general.domain.model.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
//@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto extends AbstractDto
{

    private OrderStatus status;
    private Set<OrderItemDto> cart;
    private String customerId;
    private String transactionId;


}
