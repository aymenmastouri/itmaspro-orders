package com.itmaspro.general.domain.model.dto;

import javax.persistence.Entity;
import javax.persistence.Table;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemDto extends AbstractDto
{
    private String title;
    private BigDecimal price;
    private BigDecimal amount;
    private BigDecimal quantity;
    private String currency;
    private String productId;
}
