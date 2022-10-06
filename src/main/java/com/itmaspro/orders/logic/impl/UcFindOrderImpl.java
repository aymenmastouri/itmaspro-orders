package com.itmaspro.orders.logic.impl;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import java.util.List;
import java.util.stream.Collectors;

import com.itmaspro.orders.domain.model.OrderEntity;
import com.itmaspro.orders.domain.model.dao.OrderDao;
import com.itmaspro.orders.logic.UcFindOrder;
import com.itmaspro.orders.logic.exceptions.ResourceNotFoundException;
import com.itmaspro.orders.logic.exceptions.UnauthorizedException;
import com.itmaspro.orders.rest.v1.auth.AuthContext;
import com.itmaspro.orders.rest.v1.mapper.OrderMapper;
import com.itmaspro.general.domain.model.dto.OrderDto;
@ApplicationScoped
public class UcFindOrderImpl implements UcFindOrder
{
    @Inject
    private OrderMapper orderMapper;

    @Inject
    private OrderDao orderDao;

    @Override
    public OrderDto findOrderById( String id){
        OrderEntity orderEntity = orderDao.findOne(id);
        if (orderEntity == null) {
            throw new ResourceNotFoundException( OrderDto.class.getSimpleName(), id);
        }
        return  orderMapper.map(orderEntity);
    }

    @Override
    public List<OrderDto> findOrders( Integer limit, Integer offset) {
        List<OrderEntity> customerEntities = orderDao.findAll( limit,offset, OrderEntity.ORDER_ENTITY_FIND_ALL );
        return customerEntities.stream().map( orderMapper::map).collect( Collectors.toList());
    }

}
