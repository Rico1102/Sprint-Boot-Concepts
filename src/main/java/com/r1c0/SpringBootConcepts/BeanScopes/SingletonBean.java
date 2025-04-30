package com.r1c0.SpringBootConcepts.BeanScopes;

import org.springframework.stereotype.Component;

@Component
public class SingletonBean {

    // TODO - This bean is created only once, at the time of application startup, and is shared across the entire application context. Its scope is singleton by default in Spring.

    public SingletonBean() {
        System.out.println("SingletonBean instance created: " + this);
    }

}
