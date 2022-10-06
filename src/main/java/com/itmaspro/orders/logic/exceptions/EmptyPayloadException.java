package com.itmaspro.orders.logic.exceptions;

public class EmptyPayloadException extends RuntimeException {

    private static final long serialVersionUID = 8237488163371625734L;
	private String resource;

    public EmptyPayloadException(String resource) {
        this.resource = resource;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }
}
