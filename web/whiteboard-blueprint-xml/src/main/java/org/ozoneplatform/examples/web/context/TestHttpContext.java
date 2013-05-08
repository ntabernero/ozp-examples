/* Copyright 2007 Niclas Hedhman.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied.
 *
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.ozoneplatform.examples.web.context;

import org.ops4j.lang.NullArgumentException;
import org.ops4j.pax.web.service.WebContainerContext;
import org.ops4j.pax.web.service.spi.util.Path;
import org.osgi.framework.Bundle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

/**
 * Default implementation of {@link org.osgi.service.http.HttpContext} that uses the bundle to lookup resources.
 *
 * @author Alin Dreghiciu (adreghiciu@gmail.com)
 */
public class TestHttpContext
    implements WebContainerContext
{

    /**
     * Logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(TestHttpContext.class);

    /**
     * Bundle using the {@link org.osgi.service.http.HttpService}.
     */
    private final Bundle m_bundle;

    /**
     * Constructor.
     *
     * @param bundle that bundle using the {@link org.osgi.service.http.HttpService}l cannot be null
     *
     * @throws IllegalArgumentException - If bundle is null
     */
    public TestHttpContext(final Bundle bundle)
    {
        NullArgumentException.validateNotNull( bundle, "Bundle" );
        m_bundle = bundle;
    }

    /**
     * There is no security by default, so always return "true".
     * {@inheritDoc}
     */
    public boolean handleSecurity( final HttpServletRequest httpServletRequest,
                                   final HttpServletResponse httpServletResponse )
    {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    public URL getResource( final String name )
    {
        final String normalizedname = Path.normalizeResourcePath(name);
        LOG.debug( "Searching bundle [" + m_bundle + "] for resource [" + normalizedname + "]" );
        return m_bundle.getResource( normalizedname );
    }

    /**
     * Allways returns null as there is no default way to find out the mime type.
     * {@inheritDoc}
     */
    public String getMimeType( String name )
    {
        return null;
    }

    /**
     * Search resource paths within the bundle jar.
     * {@inheritDoc}
     */
    public Set<String> getResourcePaths( final String name )
    {
        final String normalizedname = Path.normalizeResourcePath(name);
        LOG.debug( "Searching bundle [" + m_bundle + "] for resource paths of [" + normalizedname + "]" );
        final Enumeration entryPaths = m_bundle.getEntryPaths( normalizedname );
        if( entryPaths == null || !entryPaths.hasMoreElements() )
        {
            return null;
        }
        Set<String> foundPaths = new HashSet<String>();
        while( entryPaths.hasMoreElements() )
        {
            foundPaths.add( (String) entryPaths.nextElement() );
        }
        return foundPaths;
    }

    @Override
    public String toString()
    {
        return new StringBuilder()
            .append( this.getClass().getSimpleName() )
            .append( "{" )
            .append( "bundle=" ).append( m_bundle )
            .append( "}" )
            .toString();
    }

}
