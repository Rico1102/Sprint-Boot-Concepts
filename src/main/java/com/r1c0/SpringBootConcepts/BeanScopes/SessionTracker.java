package com.r1c0.SpringBootConcepts.BeanScopes;

import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class SessionTracker implements HttpSessionListener {

    private static final Set<HttpSession> sessions = ConcurrentHashMap.newKeySet();

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        sessions.add(event.getSession());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        sessions.remove(event.getSession());
    }

    public void invalidateAllSessions() {
        for (HttpSession session : sessions) {
            session.invalidate();
        }
        sessions.clear();
    }
}

