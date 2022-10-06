package com.itmaspro.orders.rest.v1.mapper;

import java.util.List;

import com.itmaspro.general.domain.model.dto.OrderDto;
import com.itmaspro.general.domain.model.dto.OrderItemDto;
import com.itmaspro.orders.domain.model.OrderEntity;
import com.itmaspro.orders.domain.model.OrderItemEntity;
import org.mapstruct.Mapper;

@Mapper
public interface OrderItemMapper
{    OrderItemDto map( OrderItemEntity entity );

    OrderItemEntity map( OrderDto dto );

    List<OrderDto> map( List<OrderEntity> entities);
}
