package com.itmaspro.orders.rest.v1.mapper;

import javax.ws.rs.NotAcceptableException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import java.util.UUID;

import com.itmaspro.general.domain.model.dto.ApiError;

public class FormatNotAcceptableMapper implements ExceptionMapper<NotAcceptableException>
{

    @Override
    public Response toResponse( NotAcceptableException exception) {

        ApiError error = new ApiError();
        error.setRef( UUID.randomUUID());
        error.setStatus(400);
        error.setCode("media.not.supported");

        return Response.status(Response.Status.BAD_REQUEST).type( MediaType.APPLICATION_JSON).entity(error).build();
    }
}