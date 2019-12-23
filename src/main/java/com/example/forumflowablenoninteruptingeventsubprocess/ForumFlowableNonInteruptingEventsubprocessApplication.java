package com.example.forumflowablenoninteruptingeventsubprocess;

import java.util.HashMap;
import java.util.Map;

import org.flowable.engine.RuntimeService;
import org.flowable.engine.delegate.JavaDelegate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ForumFlowableNonInteruptingEventsubprocessApplication {

    public static void main(String[] args) {
        SpringApplication.run(ForumFlowableNonInteruptingEventsubprocessApplication.class, args);
    }

    @Bean
    JavaDelegate delegate1(){
        return delegateExecution -> {
            System.out.println("Delegate 1");
            String foo = delegateExecution.getVariable("foo", String.class);
            System.out.println("foo: " + foo);
        };
    }
    @Bean
    JavaDelegate delegate2(){
        return delegateExecution -> {
            System.out.println("Delegate 2");
            String foo = delegateExecution.getVariable("foo", String.class);
            System.out.println("foo: " + foo);
        };
    }
    @Bean
    JavaDelegate delegate3(){
        return delegateExecution -> {
            System.out.println("Delegate 3");
            String foo = delegateExecution.getVariable("foo", String.class);
            System.out.println("foo: " + foo);
        };
    }

    @Bean
    CommandLineRunner runner(RuntimeService runtimeService){
        return args -> {
            Map<String, Object> vars = new HashMap<>();
            vars.put("foo", "bar");

            runtimeService.startProcessInstanceByKey("parallelEventProcess", vars);
        };
    }
}
