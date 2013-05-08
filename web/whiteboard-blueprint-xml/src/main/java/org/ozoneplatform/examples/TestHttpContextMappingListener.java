package org.ozoneplatform.examples;

import org.osgi.framework.Bundle;

import java.util.Map;

public class TestHttpContextMappingListener {

    Bundle bundle;

    public Bundle getBundle() {
        return bundle;
    }

    public void setBundle(Bundle bundle) {
        this.bundle = bundle;
    }

    public void register(TestHttpContextMappingInterface httpContextMapping, Map map) {
        httpContextMapping.getHttpContext().registerBundle(bundle);
    }

    public void unregister(TestHttpContextMappingInterface httpContextMapping, Map map) {
        httpContextMapping.getHttpContext().deregisterBundle(bundle);
    }

}
