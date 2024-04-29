package com.skiply.skiply.Exception;

public class ReceiptNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ReceiptNotFoundException(String msg) {
        super(msg);
    }
}
