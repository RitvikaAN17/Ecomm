package dev.ritvika.E_Comm.exception;

public class NoProductsException extends RuntimeException{
    public NoProductsException() {
    }

    public NoProductsException(String message) {
        super(message);
    }

    public NoProductsException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoProductsException(Throwable cause) {
        super(cause);
    }

    public NoProductsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
