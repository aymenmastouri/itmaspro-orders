package com.itmaspro.orders.logic.exceptions;

import com.itmaspro.general.domain.model.enums.OrderServiceErrorCode;

public class OrderServiceException extends RuntimeException {
        private OrderServiceErrorCode code;

        public OrderServiceException(OrderServiceErrorCode code) {
            this.code = code;
        }

        public OrderServiceErrorCode getCode() {
            return code;
        }}