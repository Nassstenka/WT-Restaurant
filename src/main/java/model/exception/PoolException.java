package model.exception;

public class PoolException extends Exception{
    private static final long serialVersionUID = 1L;

    public PoolException() {
        super();
    };

    public PoolException(String message) {
        super(message);
    }

    public PoolException(Exception e) {
        super(e);
    }

    public PoolException(String message, Exception e) {
        super(message, e);
    }
}
