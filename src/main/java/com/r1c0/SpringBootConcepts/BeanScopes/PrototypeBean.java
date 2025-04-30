package com.r1c0.SpringBootConcepts.BeanScopes;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PrototypeBean {

    // TODO - This bean is created everytime it is requested from the Spring context, i.e., every time it is injected into another bean.
    public PrototypeBean() {
        System.out.println("PrototypeBean instance created: " + this);
    }

}
