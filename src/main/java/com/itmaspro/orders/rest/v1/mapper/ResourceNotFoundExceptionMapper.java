package com.itmaspro.orders.rest.v1.mapper;

import javax.ws.rs.core.Response;

import org.eclipse.microprofile.rest.client.ext.ResponseExceptionMapper;

public class ResourceNotFoundExceptionMapper implements ResponseExceptionMapper<RuntimeException>
{

    @Override
    public RuntimeException toThrowable( Response response )
    {
        if ( response.getStatus() == 404 )
        {
            throw new RuntimeException( "The remote service responded with HTTP 404" );
        }
        return null;
    }
}