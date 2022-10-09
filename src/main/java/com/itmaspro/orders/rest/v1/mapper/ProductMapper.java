package com.itmaspro.orders.rest.v1.mapper;

import java.util.List;

import com.itmaspro.general.domain.model.dto.OrderDto;
import com.itmaspro.general.domain.model.dto.ProductDto;
import com.itmaspro.orders.domain.model.OrderEntity;
import com.itmaspro.orders.domain.model.ProductEntity;
import com.itmaspro.orders.domain.model.dao.ProductDao;
import org.mapstruct.Mapper;

@Mapper
public interface ProductMapper
{
    ProductDto map( ProductEntity entity );
    ProductEntity map( ProductDto dto );

    List<ProductDto> map( List<ProductEntity> entities);
}
