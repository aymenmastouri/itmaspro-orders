package com.itmaspro.orders.rest.v1.mapper;

import javax.ws.rs.NotSupportedException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import java.util.UUID;

import com.itmaspro.general.domain.model.dto.ApiError;

@Provider
public class FormatNotSupportedMapper implements ExceptionMapper<NotSupportedException>
{

    @Override
    public Response toResponse( NotSupportedException exception) {

        ApiError error = new ApiError();
        error.setRef( UUID.randomUUID());
        error.setStatus(400);
        error.setCode("format.not.supported");

        return Response.status(Response.Status.BAD_REQUEST).type( MediaType.APPLICATION_JSON).entity(error).build();
    }
}
