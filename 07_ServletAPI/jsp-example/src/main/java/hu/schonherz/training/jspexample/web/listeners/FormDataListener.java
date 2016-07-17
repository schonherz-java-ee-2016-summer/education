package hu.schonherz.training.jspexample.web.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

/**
 * Sample implementation of {@code ServletRequestAttributeListener}.
 *
 * This implementation listens to request scope attribute addition,
 * and if a {@code FormDataFilter} adds parsed form data to the request scope,
 * it simply logs this.
 */
public class FormDataListener implements ServletRequestAttributeListener {
    private static final Logger LOG = LoggerFactory.getLogger(FormDataListener.class);

    @Override
    public void attributeAdded(final ServletRequestAttributeEvent event) {
        if (event.getName().equalsIgnoreCase("formdata")) {
            LOG.debug("Form data has been added to the request as a Map.", event.getValue());
        }
    }

    @Override
    public void attributeRemoved(final ServletRequestAttributeEvent event) {
    }

    @Override
    public void attributeReplaced(final ServletRequestAttributeEvent event) {
    }
}
