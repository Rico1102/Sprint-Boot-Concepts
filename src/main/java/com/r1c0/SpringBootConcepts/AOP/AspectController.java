package com.r1c0.SpringBootConcepts.AOP;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AspectController {

    private final AspectService aspectService;

    public AspectController(AspectService aspectService) {
        this.aspectService = aspectService;
    }

    @GetMapping("/aspect/getMessage")
    public String getMessage() {
        this.aspectService.getServiceMessage("Hello from AspectController!");
        return "Hello from AspectController!";
    }

    @GetMapping("/aspect/action")
    public String performAction() {
        this.aspectService.performAction();
        return "Action performed in AspectController!";
    }

    @PostMapping("/aspect/postMessage")
    public String postMessage(@RequestBody String msg) {
        return "Hello from AspectController! Message: " + msg;
    }
}
