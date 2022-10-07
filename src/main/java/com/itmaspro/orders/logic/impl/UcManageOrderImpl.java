package com.itmaspro.orders.logic.impl;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import java.util.UUID;

import com.itmaspro.general.domain.model.dto.CustomerDto;
import com.itmaspro.general.domain.model.enums.OrderServiceErrorCode;
import com.itmaspro.general.domain.model.enums.OrderStatus;
import com.itmaspro.orders.domain.model.OrderEntity;
import com.itmaspro.orders.domain.model.OrderItemEntity;
import com.itmaspro.orders.domain.model.dao.OrderDao;
import com.itmaspro.orders.logic.UcManageOrder;
import com.itmaspro.orders.logic.exceptions.EmptyPayloadException;
import com.itmaspro.orders.logic.exceptions.IdMismatchException;
import com.itmaspro.orders.logic.exceptions.OrderServiceException;
import com.itmaspro.orders.logic.exceptions.ResourceNotFoundException;
import com.itmaspro.orders.rest.v1.client.CustomerClient;
import com.itmaspro.orders.rest.v1.mapper.OrderMapper;
import com.itmaspro.general.domain.model.dto.OrderDto;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
@Transactional
public class UcManageOrderImpl implements UcManageOrder
{
    @Inject
    OrderMapper orderMapper;
    @Inject
    OrderDao orderDao;

    @RestClient
    CustomerClient customerClient;

    public OrderDto createOrder( OrderDto order )
    {
        if ( order == null )
        {
            throw new EmptyPayloadException( OrderDto.class.getSimpleName() );
        }

        if ( order.getCustomerId() != null )
        {
            CustomerDto customerDto = customerClient.findCustomerById( order.getCustomerId() );
            System.out.println( customerDto );
        }

        if ( order.getCart() == null || order.getCart().isEmpty() )
        {
            throw new OrderServiceException( OrderServiceErrorCode.ORDER_CART_EMPTY );
        }

        Date date = Date.from( Instant.now() );

        OrderEntity orderEntity = orderMapper.map( order );
       // orderEntity.setId( UUID.randomUUID().toString() );
        orderEntity.setUpdatedAt( date );
        orderEntity.setCreatedAt( date );
        orderEntity.setStatus( OrderStatus.NEW );

        for ( OrderItemEntity orderItemEntity : orderEntity.getCart() )
        {

            //     Product product = catalogueClient.findProductById(orderItemEntity.getProductId());
            orderItemEntity.setId( null);
            orderItemEntity.setTitle( "title" );
            orderItemEntity.setCurrency( "currency" );
            orderItemEntity.setPrice( new BigDecimal( 20 ) );
            orderItemEntity.setOrder( orderEntity );
            orderItemEntity.setProductId( "100" );
            BigDecimal quantity =
                    orderItemEntity.getQuantity() != null ? orderItemEntity.getQuantity() : BigDecimal.ONE;

            orderItemEntity.setQuantity( quantity );
            orderItemEntity.setAmount( orderItemEntity.getPrice().multiply( quantity ) );

        }
        orderDao.create( orderEntity );
        return orderMapper.map( orderEntity );
    }



    @Override
    public OrderDto updateOrder( String id, OrderDto customer)  {
        if (customer == null) {
            throw new EmptyPayloadException( OrderDto.class.getSimpleName());
        }
        if (!id.equals(customer.getId())) {
            throw new IdMismatchException(id, customer.getId());
        }
        OrderEntity orderEntity = orderDao.findOne( id );

        if ( orderEntity == null) {
            throw new ResourceNotFoundException( OrderDto.class.getSimpleName(), id);
        }
        OrderEntity updatedOrderEntity = orderMapper.map(customer);
        updatedOrderEntity.setId(id);
        updatedOrderEntity.setCreatedAt( orderEntity.getCreatedAt());
        updatedOrderEntity = orderDao.update( updatedOrderEntity );
        return orderMapper.map( updatedOrderEntity );
    }

    @Override
    public void deleteOrderById( String id) {
        OrderEntity orderEntity = orderDao.findOne( id );
        if ( orderEntity == null) {
            throw new ResourceNotFoundException( OrderDto.class.getSimpleName(), id);
        }
        orderDao.delete( orderEntity );   }

    @Override
    public OrderDto completeOrder( String id )
    {
        OrderEntity orderEntity = orderDao.findOne( id );

        if (orderEntity == null) {
            throw new ResourceNotFoundException(OrderDto.class.getSimpleName(), id);
        }

        if (!orderEntity.getStatus().equals(OrderStatus.NEW)) {
            throw new OrderServiceException(OrderServiceErrorCode.ORDER_STATE_INCORRECT);
        }
        try
        {
            Thread.sleep( 1000 );
        }
        catch ( InterruptedException e )
        {
        }
        orderEntity.setStatus( OrderStatus.COMPLETED );

        return orderMapper.map(orderEntity);
    }

    @Override
    public OrderDto cancelOrder( String id )
    {
        OrderEntity orderEntity = orderDao.findOne( id );

        if (orderEntity == null) {
            throw new ResourceNotFoundException(OrderDto.class.getSimpleName(), id);
        }

        if (!orderEntity.getStatus().equals(OrderStatus.NEW)) {
            throw new OrderServiceException(OrderServiceErrorCode.ORDER_STATE_INCORRECT);
        }
        try
        {
            Thread.sleep( 1000 );
        }
        catch ( InterruptedException e )
        {
        }
        orderEntity.setStatus( OrderStatus.CANCELED );

        return orderMapper.map(orderEntity);    }
}
