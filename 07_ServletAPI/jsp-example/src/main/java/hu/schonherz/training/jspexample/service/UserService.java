package hu.schonherz.training.jspexample.service;

import hu.schonherz.training.jspexample.data.exception.UserNotFoundException;
import hu.schonherz.training.jspexample.service.domain.User;

/**
 * Simple service interface defining methods regarding users.
 */
public interface UserService {

    /**
     * Authenticates a user by name and password.
     * If a user is registered in our database with these credentials,
     * this method will return a {@link User} instance.
     *
     * @param userName
     * @param password
     *
     * @return an instance of {@link User} if found.
     * @throws UserNotFoundException when no user is present in the database with
     *                               the specified name and password.
     */
    User authenticate(String userName, String password) throws UserNotFoundException;
}
