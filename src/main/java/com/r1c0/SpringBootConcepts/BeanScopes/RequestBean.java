package com.r1c0.SpringBootConcepts.BeanScopes;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS) // TODO - Proxy mode is used to create a proxy for the request-scoped bean, allowing it to be injected into singleton-scoped beans.
public class RequestBean {

    // TODO - This bean is created for each HTTP request.

    public RequestBean() {
        System.out.println("RequestBean instance created: " + this);
    }

}
