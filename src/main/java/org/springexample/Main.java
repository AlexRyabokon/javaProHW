package org.springexample;

import org.springexample.entites.Cart;
import org.springexample.repository.ProductRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext("org.springexample");

        ProductRepository productRepository = (ProductRepository) context.getBean("productRepository");
        Cart cart = (Cart) context.getBean("cart");
        ConsoleProgram consoleProgram = (ConsoleProgram) context.getBean("consoleProgram");

        consoleProgram.startConsoleProgram(cart, productRepository);


    }


}
