package com.itmaspro.orders.rest.v1.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import java.util.UUID;

import com.itmaspro.general.domain.model.dto.ApiError;

@Provider
public class GeneralMapper implements ExceptionMapper<Exception>
{

    @Override
    public Response toResponse(Exception exception) {
        ApiError error = new ApiError(UUID.randomUUID(), 500,"internal.error" );
        exception.printStackTrace();
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error).build();
    }
}
