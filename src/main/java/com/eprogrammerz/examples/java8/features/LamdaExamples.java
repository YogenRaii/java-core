package com.eprogrammerz.examples.java8.features;

/**
 * Created by 542596 on 11/9/2016.
 *
 * Lambda expressions -> inline implementation of functional interface
 *                    -> eliminates the need of anonymous class
 */
public class LamdaExamples {

    private final static String salutation = "Hello! ";

    public static void main(String[] args) {
        GreetingService service = message -> System.out.println(salutation + message);
        service.sayHello("Yogen");
        lambdaExecutor(service);
    }

    /**
     * Lambda is function that can be created without depending on any particular class.
     * Once created, it can be passed as object and executed when required.
     *
     * @param service
     */
    public static void lambdaExecutor(GreetingService service) {
        service.sayHello("Rai");
    }
}

/**
 * functional interface
 */
@FunctionalInterface
interface GreetingService{
    void sayHello(String message);
}
