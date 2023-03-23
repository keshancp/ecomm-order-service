package com.ecomm.orderservice.exception;

public class ECommOrderException extends Exception{

    public ECommOrderException(String message) {
        super(message);
    }

    public ECommOrderException(String message, Throwable cause) {
        super(message, cause);
    }
}
