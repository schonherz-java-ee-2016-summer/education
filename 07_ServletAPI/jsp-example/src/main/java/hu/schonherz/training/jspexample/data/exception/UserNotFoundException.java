package hu.schonherz.training.jspexample.data.exception;

/**
 * Custom exception used to indicate that a user can not be found
 * in the database.
 * See {@link hu.schonherz.training.jspexample.data.dao.UserDAO}
 */
public class UserNotFoundException extends Exception {
    public UserNotFoundException(final String message) {
        super(message);
    }

    public UserNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
