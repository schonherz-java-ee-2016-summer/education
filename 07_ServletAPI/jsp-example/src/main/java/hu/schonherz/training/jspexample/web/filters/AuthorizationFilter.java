package hu.schonherz.training.jspexample.web.filters;

import hu.schonherz.training.jspexample.web.constants.HttpStatusCodes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Sample implementation of Servlet API's {@code Filter} interface.
 *
 * This filter catches an incoming HTTP request before it would go to
 * a Servlet or JSP and checks if we have a valid user stored on the
 * request session scope.
 *
 * If not, it means that no one is logged into our application yet, so
 * we redirect them to a safe place so they can't see pages that they
 * don't have permission to.
 */
public class AuthorizationFilter implements Filter {
    private static final Logger LOG = LoggerFactory.getLogger(AuthorizationFilter.class);
    private static final String KEY_AUTHORIZED = "authorized";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(final ServletRequest req, final ServletResponse res, final FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpReq = (HttpServletRequest) req;
        HttpServletResponse httpRes = (HttpServletResponse) res;
        HttpSession session = httpReq.getSession();

        if (session.getAttribute("user") == null) {
            LOG.warn("Unauthorized access to {}!", httpReq.getRequestURL());

            httpRes.setStatus(HttpStatusCodes.UNAUTHORIZED);
            httpRes.sendRedirect(httpReq.getContextPath() + "/unauth");
        } else {
            chain.doFilter(httpReq, httpRes);
        }
    }

    @Override
    public void destroy() {
    }
}
