package com.itmaspro.orders.rest.v1.client;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.itmaspro.general.domain.model.dto.CustomerDto;
import com.itmaspro.orders.rest.v1.mapper.ResourceNotFoundExceptionMapper;
import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
@RegisterProvider( ResourceNotFoundExceptionMapper.class)
@Path("customers")
@RegisterRestClient(configKey="customers-api")
@RegisterClientHeaders
public interface CustomerClient
{
    @GET
    @Path("/{id}")
    CustomerDto findCustomerById(@PathParam("id") String id);

}
