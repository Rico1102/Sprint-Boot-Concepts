package com.r1c0.SpringBootConcepts.AOP;

import org.springframework.stereotype.Service;

@Service
public class AspectService {

    public String getServiceMessage(String msg) {
        return String.format("Hello from AspectService! Message: %s", msg);
    }

    public void performAction() {
        System.out.println("Performing action in AspectService.");
    }

}
