package hu.schonherz.training.jspexample.web.servlets;

import hu.schonherz.training.jspexample.data.exception.UserNotFoundException;
import hu.schonherz.training.jspexample.service.UserService;
import hu.schonherz.training.jspexample.service.domain.User;
import hu.schonherz.training.jspexample.service.impl.UserServiceImpl;
import hu.schonherz.training.jspexample.web.constants.HttpStatusCodes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Custom implementation of Servlet API's {@link HttpServlet},
 * used to authenticate a user who wants to log in
 * with a user name and a password.
 */
public class LoginServlet extends HttpServlet {

    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASSWORD = "password";

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {

        String userName = req.getParameter(KEY_USERNAME);
        String password = req.getParameter(KEY_PASSWORD);

        try {
            User authenticatedUser = userService.authenticate(userName, password);
            HttpSession session = req.getSession(Boolean.TRUE);
            session.setAttribute("user", authenticatedUser.getName());

            resp.sendRedirect(req.getContextPath() + "/welcome");
        } catch (UserNotFoundException e) {
            resp.setStatus(HttpStatusCodes.UNAUTHORIZED);
            resp.sendRedirect(req.getContextPath() + "/index");
        }

    }
}
