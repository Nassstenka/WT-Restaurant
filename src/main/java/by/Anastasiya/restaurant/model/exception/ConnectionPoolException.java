package by.Anastasiya.restaurant.model.exception;

public class ConnectionPoolException extends Exception {
    public ConnectionPoolException(String message, Exception e)  {

        super(message, e);
    }

    public ConnectionPoolException() {
        super();
    }

    public ConnectionPoolException(String message) {
        super(message);
    }

    public ConnectionPoolException(Throwable cause) {
        super(cause);
    }
}
