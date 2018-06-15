package com.eprogrammerz.examples.java8.lambda;

/**
 * Created by 542596 on 11/9/2016.
 *
 * Lambda expressions -> inline implementation of functional interface
 *                    -> eliminates the need of anonymous class
 */
public class GreetingApp {

    private final static String salutation = "Hello! ";

    public static void main(String[] args) {
        GreetingService<String> service = message -> System.out.println(salutation + message);
        service.sayHello("Yogen");

        // pass lambda as parameter
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
interface GreetingService<T>{
    void sayHello(T message);
}
