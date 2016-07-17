package hu.schonherz.training.jspexample.data.dao.impl;

import hu.schonherz.training.jspexample.data.dao.UserDAO;
import hu.schonherz.training.jspexample.data.domain.UserDTO;
import hu.schonherz.training.jspexample.data.exception.UserNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Simple implementation of {@link UserDAO}, using
 * only a static map of pre-defined users as "database".
 */
public class UserDAOImpl implements UserDAO {
    private static final Logger LOG = LoggerFactory.getLogger(UserDAOImpl.class);

    private static List<UserDTO> users = new ArrayList<>();

    static {
        users.add(new UserDTO(1, "admin", "admin"));
        users.add(new UserDTO(2, "bobby", "asd123"));
    }

    @Override
    public UserDTO find(final String username, final String password) throws UserNotFoundException {
        LOG.info("Searching for user {} in our database...", username);
        UserDTO foundUser = null;

        for (UserDTO user : users) {
            if (user.getName().equals(username) & user.getPassword().equals(password)) {
                foundUser = user;
                break;
            }
        }

        if (foundUser == null) {
            throw new UserNotFoundException("User not found!");
        }

        return foundUser;
    }
}
