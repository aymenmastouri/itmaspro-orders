package com.itmaspro.orders.logic;

import java.util.List;

import com.itmaspro.general.domain.model.dto.OrderDto;

public interface UcFindOrder
{
    OrderDto findOrderById( String id);

    List<OrderDto> findOrders( Integer limit, Integer offset);
}
