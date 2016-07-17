package hu.schonherz.training.jspexample.web.filters;

import hu.schonherz.training.jspexample.web.utils.RequestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Custom implementation of Servlet API's {@link Filter} interface.
 *
 * This filter intercepts every incoming HTTP request and checks
 * if the request is a POST one, with a Content-Type of URL-encoded
 * form data.
 *
 * If so, this filter will process the request body into an instance
 * of {@link java.util.Map<String, String>} using {@link RequestUtils}
 * and will attach this Map to the request scope.
 *
 * This way, every doPost in your Servlets can easily get the request payload
 * from this attached Map instance.
 */
public class FormDataFilter implements Filter {
    private static final Logger LOG = LoggerFactory.getLogger(FormDataFilter.class);

    @Override
    public void init(final FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(
            final ServletRequest req,
            final ServletResponse res,
            final FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpReq = (HttpServletRequest)req;
        if (httpReq.getMethod().equalsIgnoreCase("POST")
                && httpReq.getContentType().contains("form-urlencoded")) {
            LOG.info("Parsing POST request body as form data...");
            req.setAttribute("formData", RequestUtils.parseFormData(httpReq));
        }

        filterChain.doFilter(req, res);
    }

    @Override
    public void destroy() {
    }
}
