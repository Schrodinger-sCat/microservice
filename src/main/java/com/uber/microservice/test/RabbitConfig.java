package com.uber.microservice.test;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

  @Bean
  DirectExchange exchange() {
    return new DirectExchange("test.exchange");
  }

  @Bean
  Queue queue() {
    return new Queue("test.queue", true);
  }

  @Bean
  Binding binding() {
    return BindingBuilder
        .bind(queue())
        .to(exchange())
        .with("test.key");
  }
}
