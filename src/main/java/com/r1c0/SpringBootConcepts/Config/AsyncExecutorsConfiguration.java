package com.r1c0.SpringBootConcepts.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class AsyncExecutorsConfiguration {

    @Bean("taskExecutor")
    // If no executor with the name is mentioned in @Async annotation and no executor is marked as @Primary, the executor with name taskExecutor will be used
    public ThreadPoolTaskExecutor executorForTask1() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(4);
        executor.setQueueCapacity(7);
        executor.setThreadNamePrefix("Task1-");
        executor.initialize();
        return executor;
    }

    @Bean("executorForTask2")
    @Primary
    // If no name is provided in the @Async annotation, the executor with @Primary will be used
    public ThreadPoolTaskExecutor executorForTask2() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(4);
        executor.setQueueCapacity(7);
        executor.setThreadNamePrefix("Task2-");
        executor.initialize();
        return executor;
    }

    @Bean("executorForTask3")
    // Least priority will only be picked up when the executor name is mentioned in the @Async annotation
    public ThreadPoolTaskExecutor executorForTask3() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(4);
        executor.setQueueCapacity(7);
        executor.setThreadNamePrefix("Task3-");
        executor.initialize();
        return executor;
    }

}
