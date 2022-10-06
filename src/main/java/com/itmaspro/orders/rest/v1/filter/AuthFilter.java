package com.itmaspro.orders.rest.v1.filter;


import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.UUID;

import com.itmaspro.general.domain.model.dto.ApiError;

@Provider
public class AuthFilter implements ContainerRequestFilter{

    @Override public void filter(ContainerRequestContext requestContext) throws IOException
    {
        String authHeader = requestContext.getHeaderString("Authorization");

        if (authHeader == null || authHeader.isEmpty()) {
            ApiError error = new ApiError(UUID.randomUUID(),401, "unauthorized");
            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).entity(error).build());
        }

    }
}


