package com.itmaspro.orders.logic;

import com.itmaspro.general.domain.model.dto.OrderDto;
import com.itmaspro.general.domain.model.dto.ProductDto;

public interface UcFindProduct
{
    ProductDto findProductById( String id);
}
