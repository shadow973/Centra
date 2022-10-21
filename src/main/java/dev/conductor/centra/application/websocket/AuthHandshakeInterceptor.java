package dev.conductor.centra.application.websocket;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import dev.conductor.centra.application.security.SecurityConstants;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@Component
public class AuthHandshakeInterceptor implements HandshakeInterceptor {

    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
        String authHeader = UriComponentsBuilder.fromHttpRequest(request).build().getQueryParams().getFirst("authorization");
        
        if (authHeader == null) {
            return true;
        }
        
        String jwtToken = authHeader.replace("Bearer%20", "");
        String principalUser = getAuthentication(jwtToken);

        attributes.put("principalName", principalUser);

        return true;
    }

    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception exception) {

    }

    private String getAuthentication(String token) {
        // parse the token.
        return JWT.require(Algorithm.HMAC512(SecurityConstants.SECRET.getBytes()))
                .build()
                .verify(token.replace(SecurityConstants.TOKEN_PREFIX, ""))
                .getSubject();
    }
}
