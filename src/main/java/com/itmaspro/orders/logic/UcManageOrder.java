package com.itmaspro.orders.logic;

import com.itmaspro.general.domain.model.dto.OrderDto;

public interface UcManageOrder
{
    OrderDto createOrder( OrderDto customer);

    OrderDto updateOrder( String id, OrderDto customer);

    void deleteOrderById( String id);

    OrderDto completeOrder( String id );

    OrderDto cancelOrder( String id );
}
