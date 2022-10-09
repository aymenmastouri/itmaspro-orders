package com.itmaspro.orders.domain.model.dao;
import javax.enterprise.context.ApplicationScoped;

import com.itmaspro.orders.domain.model.ProductEntity;
@ApplicationScoped

public class ProductDao extends AbstractJpaDAO<ProductEntity>
{
    public ProductDao()
    {
        setClazz( ProductEntity.class );
    }
}