package com.itmaspro.orders.rest.v1;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import java.util.HashSet;
import java.util.Set;

import com.itmaspro.orders.rest.v1.filter.AuthFilter;
import com.itmaspro.orders.rest.v1.filter.CorsFilter;
import com.itmaspro.orders.rest.v1.filter.LoggerInterceptor;
import com.itmaspro.orders.rest.v1.mapper.EmptyPayloadMapper;
import com.itmaspro.orders.rest.v1.mapper.PrimeNumberChecker;
import com.itmaspro.orders.rest.v1.mapper.ResourceNotFoundMapper;
import com.itmaspro.orders.rest.v1.provider.JacksonProvider;
@ApplicationPath("/v1")
public class OrderApplication extends Application
{

    @Override
    public Set<Class<?>> getClasses()
    {

        Set<Class<?>> classes = new HashSet<>();

        // classes.add(JacksonJsonProvider.class);

        classes.add( JacksonProvider.class );

        classes.add( OrderRestService.class );
        classes.add( PrimeNumberChecker.class );
        classes.add( EmptyPayloadMapper.class );
        classes.add( ResourceNotFoundMapper.class );

        classes.add( AuthFilter.class );
        classes.add( CorsFilter.class );
        classes.add( LoggerInterceptor.class );

        return classes;
    }
}
