package com.skiply.skiply.Exception;

public class StudentAlreadyExistException extends  RuntimeException {
    private static final long serialVersionUID = 1L;
    public StudentAlreadyExistException(String msg) {
        super(msg);
    }
}
