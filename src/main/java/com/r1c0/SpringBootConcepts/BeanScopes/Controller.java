package com.r1c0.SpringBootConcepts.BeanScopes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bean-scopes")
public class Controller {

    private final PrototypeBean prototypeBean;
    private final RequestBean requestBean;
    private final SingletonBean singletonBean;

    private final SessionBean sessionBean;

    private final SessionTracker sessionTracker;

    public Controller(PrototypeBean prototypeBean, RequestBean requestBean, SingletonBean singletonBean, SessionBean sessionBean, SessionTracker sessionTracker) {
        this.prototypeBean = prototypeBean;
        this.requestBean = requestBean;
        this.singletonBean = singletonBean;
        this.sessionBean = sessionBean;
        this.sessionTracker = sessionTracker;
    }


    @GetMapping("/prototype")
    public String getPrototypeBean() {
        return "PrototypeBean instance: " + prototypeBean;
    }

    @GetMapping("/request")
    public String getRequestBean() {
        return "RequestBean instance: " + requestBean;
    }

    @GetMapping("/singleton")
    public String getSingletonBean() {
        return "SingletonBean instance: " + singletonBean;
    }

    @GetMapping("/session")
    public String getSessionBean() {
        return "SessionBean instance: " + sessionBean;
    }

    @GetMapping("/invalidate-session")
    public String invalidateAllSession() {
        // TODO - This method is used to invalidate all sessions. It will create a new SessionBean instance for the next request.
        sessionTracker.invalidateAllSessions();
        return "Session invalidated. A new SessionBean instance will be created for the next request.";
    }

}
