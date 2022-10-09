package com.itmaspro.orders.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


import java.io.Serializable;
import java.math.BigDecimal;

import com.itmaspro.general.domain.model.ApplicationPersistenceEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "products")
public class ProductEntity extends ApplicationPersistenceEntity implements Serializable
{
        @Column(name = "title")
        private String title;

        @Column(name = "price")
        private BigDecimal price;

        @Column(name = "currency")
        private String currency;


        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public BigDecimal getPrice() {
            return price;
        }

        public void setPrice(BigDecimal price) {
            this.price = price;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }
}