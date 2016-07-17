package hu.schonherz.training.jspexample.web.utils;

import org.apache.commons.lang3.StringEscapeUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Utility class for all kinds of funky HTTP request-related
 * stuff.
 */
public final class RequestUtils {

    /**
     * Converts request body to key-value pairs for easier data handling.
     * Also does URL decoding and HTML escaping for safety measures.
     *
     * @param req
     *      an instance of {@link HttpServletRequest} to process data from.
     * @return
     *      an instance of {@link Map} containing parsed body.
     *
     * @throws IOException
     */
    public static Map<String, String> parseFormData(final HttpServletRequest req) throws IOException {
        Map<String, String> formData = new HashMap<>();

        try (Scanner sc = new Scanner(req.getReader())) {
            sc.useDelimiter("=|&");
            while (sc.hasNext()) {
                String key = URLDecoder.decode(sc.next());
                String value = URLDecoder.decode(sc.next());
                key = StringEscapeUtils.escapeHtml4(key);
                value = StringEscapeUtils.escapeHtml4(value);

                formData.put(key, value);
            }
        }

        return formData;
    }

    private RequestUtils(){}
}
