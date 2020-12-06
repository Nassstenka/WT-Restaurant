package by.Anastasiya.restaurant.model.exception;

public class ServiceUserAlreadyExistsException extends Exception{
    public ServiceUserAlreadyExistsException(String message, Exception e)  {
        super(message, e);
    }

    public ServiceUserAlreadyExistsException() {
        super();
    }

    public ServiceUserAlreadyExistsException(String message) {
        super(message);
    }

    public ServiceUserAlreadyExistsException(Throwable cause) {
        super(cause);
    }
}
