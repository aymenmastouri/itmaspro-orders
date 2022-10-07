package com.itmaspro.orders.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.math.BigDecimal;

import com.itmaspro.general.domain.model.ApplicationPersistenceEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "orderItems")
public class OrderItemEntity extends ApplicationPersistenceEntity implements Serializable
{

    @Column( name = "title" )
    private String title;

    @Column( name = "price" )
    private BigDecimal price;

    @Column( name = "amount" )
    private BigDecimal amount;

    @Column( name = "quantity" )
    private BigDecimal quantity;

    @Column( name = "currency" )
    private String currency;

    @NotNull
    @Column( name = "productId" )
    private String productId;

    @NotNull
    @ManyToOne
    @JoinColumn( name = "order_id" )
    private OrderEntity order;
}