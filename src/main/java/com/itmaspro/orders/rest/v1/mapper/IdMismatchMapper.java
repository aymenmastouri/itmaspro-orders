package com.itmaspro.orders.rest.v1.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import java.util.UUID;

import com.itmaspro.general.domain.model.dto.ApiError;
import com.itmaspro.orders.logic.exceptions.IdMismatchException;

@Provider
public class IdMismatchMapper implements ExceptionMapper<IdMismatchException>
{

    @Override
    public Response toResponse( IdMismatchException exception) {

        ApiError error = new ApiError();
        error.setRef( UUID.randomUUID());
        error.setStatus(400);
        error.setCode("resource.id.mismatch");

        return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
    }
}
