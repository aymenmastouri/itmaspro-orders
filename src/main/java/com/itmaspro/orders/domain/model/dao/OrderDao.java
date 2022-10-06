package com.itmaspro.orders.domain.model.dao;

import javax.enterprise.context.ApplicationScoped;
import com.itmaspro.orders.domain.model.OrderEntity;

@ApplicationScoped
public class OrderDao extends AbstractJpaDAO<OrderEntity>
{
    public OrderDao(){
        setClazz( OrderEntity.class);
    }
}
