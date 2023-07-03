package org.springexample;

import org.springexample.entites.Cart;
import org.springexample.repository.ProductRepository;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public  class SpringConfig {

    @Bean
    ProductRepository productRepository() {
        return new ProductRepository();
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    Cart cart(){
        return new Cart();
    }

    @Bean
    ConsoleProgram consoleProgram(){
        return new ConsoleProgram();
    }
}