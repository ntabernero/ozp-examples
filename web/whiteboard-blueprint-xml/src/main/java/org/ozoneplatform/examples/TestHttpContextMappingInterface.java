package org.ozoneplatform.examples;

import org.ops4j.pax.web.extender.whiteboard.HttpContextMapping;
import org.osgi.framework.Bundle;

import java.util.Map;

public interface TestHttpContextMappingInterface
        extends HttpContextMapping {

    /**
     * @see org.ops4j.pax.web.extender.whiteboard.HttpContextMapping#getHttpContext()
     */
    public TestSharedWebContainerContextInterface getHttpContext();

    /**
     * Setter.
     *
     * @param httpContextId context id; can be null
     */
    public void setHttpContextId(final String httpContextId);

    /**
     * Setter.
     *
     * @param path context path; can be null
     */
    public void setPath(final String path);

    /**
     * Setter.
     *
     * @param parameters context parameters; can be null
     */
    public void setParameters(final Map<String, String> parameters);

    /**
     * Setter.
     *
     * @param httpContext http context; can be null case when a default http context will be used
     */
    public void setHttpContext(TestSharedWebContainerContextInterface httpContext);

    public Bundle getBundle();

    public void setBundle(Bundle bundle);

    public void init();

}