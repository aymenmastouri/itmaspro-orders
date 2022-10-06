package com.itmaspro.orders.rest.v1.filter;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.ReaderInterceptor;
import javax.ws.rs.ext.ReaderInterceptorContext;
import javax.ws.rs.ext.WriterInterceptor;
import javax.ws.rs.ext.WriterInterceptorContext;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Logger;

@Provider
public class LoggerInterceptor implements WriterInterceptor, ReaderInterceptor
{
    private static final Logger logger = Logger.getLogger(LoggerInterceptor.class.getName());

    @Override
    public Object aroundReadFrom(ReaderInterceptorContext context) throws IOException, WebApplicationException {

        InputStream inputStream = context.getInputStream();

        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes);

        String requestContent = new String(bytes);

        logger.info("Request: " + requestContent);

        context.setInputStream(new ByteArrayInputStream(requestContent.getBytes()));

        return context.proceed();
    }

    @Override
    public void aroundWriteTo(WriterInterceptorContext context) throws IOException, WebApplicationException
    {

        OutputStream originalStream = context.getOutputStream();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        context.setOutputStream(baos);

        try {

            context.proceed();
        } finally {

            logger.info("Response: " + baos.toString("UTF-8"));

            baos.writeTo(originalStream);
            baos.close();

            context.setOutputStream(originalStream);
        }
    }
}