package com.itmaspro.orders.rest.v1.mapper;

import java.util.List;

import com.itmaspro.orders.domain.model.OrderEntity;
import com.itmaspro.general.domain.model.dto.OrderDto;
import org.mapstruct.Mapper;

@Mapper(uses = { OrderItemMapper.class })
public interface OrderMapper
{
    OrderDto map( OrderEntity entity );
    OrderEntity map( OrderDto dto );

    List<OrderDto> map( List<OrderEntity> entities);
}
