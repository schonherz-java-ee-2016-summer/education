package hu.schonherz.training.jspexample.service.impl;

import hu.schonherz.training.jspexample.data.dao.UserDAO;
import hu.schonherz.training.jspexample.data.dao.impl.UserDAOImpl;
import hu.schonherz.training.jspexample.data.domain.UserDTO;
import hu.schonherz.training.jspexample.data.exception.UserNotFoundException;
import hu.schonherz.training.jspexample.service.UserService;
import hu.schonherz.training.jspexample.service.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Simple implementation of {@link UserService}.
 */
public class UserServiceImpl implements UserService {
    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    // This component depends on the UserDAO interface.
    // Remember SOLID! Always depend on abstractions!
    private UserDAO userDao = new UserDAOImpl();

    @Override
    public User authenticate(final String userName, final String password) throws UserNotFoundException {
        LOG.info("Authenticating user with name {}...", userName);
        return convert(userDao.find(userName, password));
    }

    /**
     * Utility method to convert an instance of {@link UserDTO} into
     * an instance of {@link User}.
     *
     * @param userDTO the {@link UserDTO} to convert.
     * @return the converted {@link User} instance.
     */
    private User convert(final UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setPassword(userDTO.getPassword());
        return user;
    }
}
