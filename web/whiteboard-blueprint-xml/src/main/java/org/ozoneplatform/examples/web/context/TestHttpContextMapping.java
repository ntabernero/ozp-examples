package org.ozoneplatform.examples.web.context;

import org.ops4j.pax.web.extender.whiteboard.HttpContextMapping;
import org.osgi.framework.Bundle;
import org.ozoneplatform.examples.TestHttpContextMappingInterface;
import org.ozoneplatform.examples.TestSharedWebContainerContextInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class TestHttpContextMapping
        implements TestHttpContextMappingInterface
{

    public static Logger logger = LoggerFactory.getLogger(TestHttpContextMapping.class);

    /**
     * Context id.
     */
    private String m_httpContextId;
    /**
     * Context path.
     */
    private String m_path;
    /**
     * Context parameters.
     */
    private Map<String, String> m_parameters;
    /**
     * Http context.
     */
    private TestSharedWebContainerContextInterface m_httpContext;

    private Bundle bundle;

    /**
     * @see HttpContextMapping#getHttpContextId()
     */
    public String getHttpContextId()
    {
        return m_httpContextId;
    }

    /**
     * @see HttpContextMapping#getPath()
     */
    public String getPath()
    {
        return m_path;
    }

    /**
     * @see HttpContextMapping#getParameters()
     */
    public Map<String, String> getParameters()
    {
        return m_parameters;
    }

    /**
     * @see HttpContextMapping#getHttpContext()
     */
    public TestSharedWebContainerContextInterface getHttpContext()
    {
        return m_httpContext;
    }

    /**
     * Setter.
     *
     * @param httpContextId context id; can be null
     */
    public void setHttpContextId( final String httpContextId )
    {
        m_httpContextId = httpContextId;
    }

    /**
     * Setter.
     *
     * @param path context path; can be null
     */
    public void setPath( final String path )
    {
        m_path = path;
    }

    /**
     * Setter.
     *
     * @param parameters context parameters; can be null
     */
    public void setParameters( final Map<String, String> parameters )
    {
        m_parameters = parameters;
    }

    /**
     * Setter.
     *
     * @param httpContext http context; can be null case when a default http context will be used
     */
    public void setHttpContext( TestSharedWebContainerContextInterface httpContext )
    {
        m_httpContext = httpContext;
    }

    public Bundle getBundle() {
        return bundle;
    }

    public void setBundle(Bundle bundle) {
        this.bundle = bundle;
    }

    public void init() {
        logger.info("registering bundle:"+ bundle);
        m_httpContext.registerBundle(bundle);
    }

    @Override
    public String toString()
    {
        return new StringBuffer()
                .append( this.getClass().getSimpleName() )
                .append( "{" )
                .append("httpContextId=").append(m_httpContextId)
                .append( ",bundle=" ).append( bundle )
                .append( ",path=" ).append( m_path )
                .append( ",params=" ).append( m_parameters )
                .append( ",httpContext=" ).append( m_httpContext )
                .append( "}" )
                .toString();
    }

}