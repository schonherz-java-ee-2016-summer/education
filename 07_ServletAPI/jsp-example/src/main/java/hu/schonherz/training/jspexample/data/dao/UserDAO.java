package hu.schonherz.training.jspexample.data.dao;

import hu.schonherz.training.jspexample.data.domain.UserDTO;
import hu.schonherz.training.jspexample.data.exception.UserNotFoundException;

/**
 * DAO interface to manipulate user data.
 */
public interface UserDAO {

    /**
     * Retrieves a {@link UserDTO} instance by name and password.
     *
     * @param username a String representing the name of the user
     * @param password the users password
     *
     * @return an instance of {@link UserDTO} if it found in the database.
     *
     * @throws UserNotFoundException when there is no user with the specified
     *                               name and password
     */
    UserDTO find(String username, String password) throws UserNotFoundException;
}
