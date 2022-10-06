package com.itmaspro.orders.rest.v1;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.itmaspro.orders.logic.UcFindOrder;
import com.itmaspro.orders.logic.UcManageOrder;
import com.itmaspro.general.domain.model.dto.OrderDto;

@Path("/orders")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class OrderRestService
{
    @Inject
    private UcFindOrder ucFindOrder;
    @Inject
    private UcManageOrder ucManageOrder;

    @GET
    public Response getOrders( @QueryParam("limit") Integer limit,
                               @QueryParam("offset") Integer offset) {
        return Response.ok(ucFindOrder.findOrders(limit, offset))
                .header("X-Total-Count", 0).build();
    }

    @GET
    @Path("/{id}")
    public Response getOrder( @PathParam("id") String id) {

        return Response.ok(ucFindOrder.findOrderById(id)).build();
    }

    @POST
    public Response createOrder( OrderDto newOrder){
        return Response.ok( ucManageOrder.createOrder(newOrder)).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateOrder( @PathParam("id") String id, OrderDto updatedOrder){

        return Response.ok( ucManageOrder.updateOrder(id, updatedOrder)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteOrder( @PathParam("id") String id){

        ucManageOrder.deleteOrderById(id);

        return Response.noContent().build();
    }

    @POST
    @Path("/{id}/complete")
    public Response completeOrder(@PathParam("id") String id) {

        OrderDto order = ucManageOrder.completeOrder(id);

        return Response.ok(order).build();
    }

    @POST
    @Path("/{id}/cancel")
    public Response cancelOrder(@PathParam("id") String id) {

        OrderDto order = ucManageOrder.cancelOrder(id);

        return Response.ok(order).build();
    }
}
