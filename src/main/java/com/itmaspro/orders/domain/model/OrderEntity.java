package com.itmaspro.orders.domain.model;

import com.itmaspro.general.domain.model.ApplicationPersistenceEntity;
import com.itmaspro.general.domain.model.enums.OrderStatus;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "orders")
@NamedQueries({
        @NamedQuery( name = OrderEntity.ORDER_ENTITY_FIND_ALL, query = "SELECT c FROM OrderEntity c"),
        @NamedQuery( name = OrderEntity.ORDER_ENTITY_FIND_ALL_COUNT, query = "SELECT count(c) FROM OrderEntity c")
})
public class OrderEntity extends ApplicationPersistenceEntity implements Serializable
{

    public static final String ORDER_ENTITY_FIND_ALL = "OrderEntity.findAll";
    public static final String ORDER_ENTITY_FIND_ALL_COUNT = "OrderEntity.findAllCount";
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private OrderStatus status;

    @NotNull
    @Column(name = "customer_id")
    private String customerId;

    @Column(name = "transaction_id")
    private String transactionId;

    @OneToMany( mappedBy = "order", cascade = CascadeType.ALL)
    private Set<OrderItemEntity> cart;
}

