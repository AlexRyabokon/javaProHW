package org.example.config;


import org.example.entities.Order;
import org.example.entities.Product;
import org.example.repository.OrderRepository;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@ComponentScan("org.example")
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
   
    @Bean
    public OrderRepository orderRepository(){
        return new OrderRepository();
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Order order(){
        return new Order();
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public Product product(){
        return new Product();
    }

}
