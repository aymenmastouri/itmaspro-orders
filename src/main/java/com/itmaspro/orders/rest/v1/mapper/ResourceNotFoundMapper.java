package com.itmaspro.orders.rest.v1.mapper;

import com.itmaspro.orders.logic.exceptions.ResourceNotFoundException;
import com.itmaspro.general.domain.model.dto.ApiError;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.UUID;

@Provider
public class ResourceNotFoundMapper implements ExceptionMapper<ResourceNotFoundException>
{
    @Override public Response toResponse(ResourceNotFoundException exception)
    {
        ApiError error = new ApiError(UUID.randomUUID(),404,"resource.not.found");
        return Response.status(Response.Status.NOT_FOUND).entity(error).build();
    }
}
