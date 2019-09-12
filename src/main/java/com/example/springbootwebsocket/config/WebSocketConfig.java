package com.example.springbootwebsocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration // this is a configuration class
@EnableWebSocketMessageBroker // this is a websocket message broker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // Set the broker information: a message broker is a program that transmit a message from a
        // sender to a receiver
        // 1) enable an in-memory message broker to carry the messges back to client on destination.
        registry.enableSimpleBroker(("/topic")); // enable the broker and add a prefix to it

        // 2) set the application destination prefixes so that the message go to correct channel
        registry.setApplicationDestinationPrefixes("/app");

    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // need to find a prefix for your endpoint to enable Spring’s STOMP support and SockJS fallback options
        // so that alternative messaging options may be used if WebSockets are not available

        // Create the WebSocket
        registry.addEndpoint("/websocket-demo").withSockJS();
    }
}
