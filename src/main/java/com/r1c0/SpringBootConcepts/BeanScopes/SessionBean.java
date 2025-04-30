package com.r1c0.SpringBootConcepts.BeanScopes;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS) // TODO - Proxy mode is used to create a proxy for the session-scoped bean, allowing it to be injected into singleton-scoped beans.
public class SessionBean {

    // TODO - This bean is created for each HTTP session.

    public SessionBean() {
        System.out.println("SessionBean instance created: " + this);
    }

}
