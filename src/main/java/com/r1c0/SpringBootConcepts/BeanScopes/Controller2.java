package com.r1c0.SpringBootConcepts.BeanScopes;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bean-scopes2")
public class Controller2 {

    // TODO - This controller is used to demonstrate that prototype bean is instantiated twice for each controllers.
    private final PrototypeBean prototypeBean;

    public Controller2(PrototypeBean prototypeBean) {
        this.prototypeBean = prototypeBean;
    }

}
