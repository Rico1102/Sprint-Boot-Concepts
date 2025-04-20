package com.r1c0.SpringBootConcepts.Service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {

    @Async("executorForTask3")
    // Highest priority given to the executor mentioned in @Async annotation
    public void asyncMethod(){
        System.out.println("Executing async method in thread: " + Thread.currentThread().getName());
    }

}
