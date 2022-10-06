package com.itmaspro.orders.rest.v1;

import javax.inject.Singleton;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.quarkus.jackson.ObjectMapperCustomizer;
//@Singleton
public class RegisterCustomModuleCustomizer implements ObjectMapperCustomizer
{
    @Override
    public void customize( ObjectMapper mapper )
    {
      //  mapper.registerModule(new SimpleModule());
      //  mapper.configure( DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,true );

    }
}
