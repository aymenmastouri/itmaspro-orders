package com.itmaspro.orders.rest.v1.mapper;


import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import java.util.UUID;

import com.itmaspro.general.domain.model.dto.ApiError;
import com.itmaspro.orders.logic.exceptions.OrderServiceException;

@Provider
public class OrderServiceMapper implements ExceptionMapper<OrderServiceException>
{

    @Override
    public Response toResponse( OrderServiceException exception) {

        ApiError apiError = new ApiError();
        apiError.setRef( UUID.randomUUID());
        apiError.setStatus(400);
        apiError.setCode(exception.getCode().getCode());

        return Response.status(Response.Status.BAD_REQUEST).entity(apiError).build();
    }
}
