package by.Anastasiya.restaurant.model.exception;

public class ServiceException extends Exception {
    public ServiceException(String message, Exception e)  {

        super(message, e);
    }

    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }
}
