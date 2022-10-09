package com.itmaspro.orders.logic.impl;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.itmaspro.general.domain.model.dto.ProductDto;
import com.itmaspro.orders.domain.model.ProductEntity;
import com.itmaspro.orders.domain.model.dao.ProductDao;
import com.itmaspro.orders.logic.UcFindProduct;
import com.itmaspro.orders.logic.exceptions.ResourceNotFoundException;
import com.itmaspro.orders.rest.v1.mapper.ProductMapper;

@ApplicationScoped
public class UcFindProductImpl implements UcFindProduct
{
    @Inject
    ProductDao productDao;
    @Inject
    ProductMapper productMapper;
    @Override
    public ProductDto findProductById( String id )
    {
        ProductEntity productEntity = productDao.findOne( id );
        if(productEntity == null){
            throw  new ResourceNotFoundException(ProductEntity.class.getSimpleName(),id );
        }
        return productMapper.map( productEntity );
    }
}
