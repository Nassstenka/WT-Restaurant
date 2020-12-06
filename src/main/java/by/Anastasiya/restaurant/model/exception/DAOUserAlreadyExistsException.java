package by.Anastasiya.restaurant.model.exception;

public class DAOUserAlreadyExistsException extends Exception {
    public DAOUserAlreadyExistsException(String message, Exception e)  {

        super(message, e);
    }

    public DAOUserAlreadyExistsException() {
        super();
    }

    public DAOUserAlreadyExistsException(String message) {
        super(message);
    }

    public DAOUserAlreadyExistsException(Throwable cause) {
        super(cause);
    }

}
