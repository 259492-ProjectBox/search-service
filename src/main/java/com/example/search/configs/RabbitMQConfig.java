package com.example.search.configs;
import com.example.search.consumers.RabbitMQConsumer;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.DirectMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    @Value("${rabbitmq.exchange.name}")
    private String topicExchangeName;

    @Value("${rabbitmq.queue.name}")
    private String queueName;

    @Value("${rabbitmq.routing.key}")
    private String routingKey;

    @Bean
    public Queue queue() {
        return new Queue(queueName, true);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange(topicExchangeName);
    }

    @Bean
    public Binding binding(Queue queue, Exchange exchange) {
        return BindingBuilder.bind(queue)
                .to(exchange)
                .with(routingKey)
                .noargs();
    }

    @Bean
    public ConnectionFactory connectionFactory(@Value("${rabbitmq.host}") String host,
                                               @Value("${rabbitmq.port}") int port,
                                               @Value("${rabbitmq.username}") String username,
                                               @Value("${rabbitmq.password}") String password) {
        CachingConnectionFactory factory = new CachingConnectionFactory(host, port);
        factory.setUsername(username);
        factory.setPassword(password);
        return factory;
    }

    @Bean
    MessageListenerAdapter listenerAdapter(RabbitMQConsumer consumer) {
        // Assuming the Receiver class has a method called receiveMessage
        return new MessageListenerAdapter(consumer, "receiveMessage");
    }

    @Bean
    DirectMessageListenerContainer directMessageListenerContainer(ConnectionFactory connectionFactory,
                                                                  MessageListenerAdapter listenerAdapter) {
        DirectMessageListenerContainer container = new DirectMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(queueName);
        container.setMessageListener(listenerAdapter);
        container.setAutoStartup(true);
        return container;
    }
}
