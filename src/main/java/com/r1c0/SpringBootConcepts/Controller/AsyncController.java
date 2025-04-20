package com.r1c0.SpringBootConcepts.Controller;

import com.r1c0.SpringBootConcepts.Service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsyncController {

    private final AsyncService asyncService;

    @Autowired
    public AsyncController(AsyncService asyncService) {
        this.asyncService = asyncService;
    }


    @GetMapping("/runAsync")
    public void runAsyncMethod(){
        System.out.println("Executing controller method in thread: " + Thread.currentThread().getName());
        this.asyncService.asyncMethod();
    }

}
