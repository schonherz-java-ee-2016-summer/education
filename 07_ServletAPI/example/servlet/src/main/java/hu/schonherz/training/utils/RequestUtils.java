package hu.schonherz.training.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.Properties;
import java.util.Scanner;

/**
 * Utility methods for dealing with HTTP requests.
 */
public final class RequestUtils {
    private static final Logger LOG = LoggerFactory.getLogger(RequestUtils.class);

    /**
     * Given an {@code HttpServletRequest} object, this method will read its request body
     * as URL encoded form data and will construct a Java Properties object from it
     * for easier data manipulation.
     *
     * @param req
     *
     * @return an instance of Java Properties, with entries populated from the request body.
     * If the request's content type is not form data or reading data fails, the returned instance will be empty.
     */
    public static Properties parseFormBody(final HttpServletRequest req) {
        Properties properties = new Properties();

        // Fail-fast when we see that the content type is not right
        if (!req.getContentType().equalsIgnoreCase("application/x-www-form-urlencoded")) {
            return properties;
        }

        try (Scanner sc = new Scanner(req.getReader())) {
            sc.useDelimiter("=|&");

            while (sc.hasNext()) {
                String key = URLDecoder.decode(sc.next(), "utf-8");
                String value = URLDecoder.decode(sc.next(), "utf-8");
                properties.put(key, value);
            }
        } catch (final IOException e) {
            LOG.warn("Error while parsing request body. Returning with empty Java Properties.", e);
        }

        return properties;
    }

    private RequestUtils() {}
}
