package com.itmaspro.general.domain.model.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
//@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto extends AbstractDto
{
    protected String title;
    protected BigDecimal price;
    protected String currency;
  //  protected Supplier supplier;
}
