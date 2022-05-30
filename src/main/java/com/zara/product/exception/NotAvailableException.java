package com.zara.product.exception;

public class NotAvailableException extends RuntimeException {

    private static final long serialVersionUID = -6084297047582034468L;

    public NotAvailableException(String msg) {
        super(msg);
    }
}