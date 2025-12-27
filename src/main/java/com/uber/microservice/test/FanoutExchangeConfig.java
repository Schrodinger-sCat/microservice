package com.uber.microservice.test;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutExchangeConfig {

    public static final String FANOUT_EXCHANGE = "loki.fanout.exchange";
    public static final String FANOUT_QUEUE1 = "loki.fanout.queue1";
    public static final String FANOUT_QUEUE2 = "loki.fanout.queue2";

    @Bean(name = "fanoutExchange")
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(FANOUT_EXCHANGE);
    }

    @Bean(name = "fanoutQueue1")
    public Queue fanoutQueue1() {
        return QueueBuilder
                .durable(FANOUT_QUEUE1)
                .quorum()
                .build();
    }

    @Bean(name = "fanoutQueue2")
    public Queue fanoutQueue2() {
        return QueueBuilder
                .durable(FANOUT_QUEUE2)
                .quorum()
                .build();
    }

    @Bean("fanoutBinding1")
    public Binding fanoutBinding1() {
        return BindingBuilder.bind(fanoutQueue1()).to(fanoutExchange());
    }

    @Bean(name = "fanoutBinding2")
    Binding fanoutBinding2() {
        return BindingBuilder.bind(fanoutQueue2()).to(fanoutExchange());
    }
}

