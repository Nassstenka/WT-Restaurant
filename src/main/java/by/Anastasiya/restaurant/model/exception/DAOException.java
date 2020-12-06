package by.Anastasiya.restaurant.model.exception;

public class DAOException extends Exception {
    public DAOException(String message, Exception e)  {

        super(message, e);
    }

    public DAOException() {
        super();
    }

    public DAOException(String message) {
        super(message);
    }

    public DAOException(Throwable cause) {
        super(cause);
    }
}
