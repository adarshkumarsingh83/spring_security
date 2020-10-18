package com.espark.adarsh.exception;


public class ApplicationException extends RuntimeException {

    private String exceptionCode;

    public ApplicationException(String exceptionCode) {
        super(exceptionCode);
        this.exceptionCode = exceptionCode;
    }

    public ApplicationException(String message, String exceptionCode) {
        super(message);
        this.exceptionCode = exceptionCode;
    }

    public ApplicationException(String message, Throwable cause, String exceptionCode) {
        super(message, cause);
        this.exceptionCode = exceptionCode;
    }

    public ApplicationException(Throwable cause, String exceptionCode) {
        super(cause);
        this.exceptionCode = exceptionCode;
    }

    public ApplicationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String exceptionCode) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.exceptionCode = exceptionCode;
    }
}
