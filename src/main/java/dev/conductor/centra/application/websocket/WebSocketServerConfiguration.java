package dev.conductor.centra.application.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketServerConfiguration implements WebSocketConfigurer {

    @Autowired
    protected ControllerHandler webSocketHandler;

    @Autowired
    private AuthHandshakeInterceptor interceptor;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(webSocketHandler, "/centra")
                .addInterceptors(interceptor)
                .setAllowedOriginPatterns("*")
                .withSockJS();
    }
}
