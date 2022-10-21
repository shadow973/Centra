package dev.conductor.centra.application.websocket;

import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Component
public class ControllerHandler extends TextWebSocketHandler {

    @Autowired
    private ControllerResponseResolver controllerResponseResolver;

    final private Map<String, WebSocketSession> mySessionMap = new HashMap<>();
    final private static Gson gson = new Gson();


    @Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        mySessionMap.remove(session.getId());
	}

    @Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        if (!mySessionMap.containsKey(session.getId())) {
            mySessionMap.put(session.getId(), session);
        }
	}

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage jsonTextMessage) throws Exception {
        String principalUser = (String) session.getAttributes().getOrDefault("principalName", "");
        Principal principal = () -> principalUser;

        Map<Object, Object> requestMap = gson.fromJson(jsonTextMessage.getPayload(), Map.class);
        Map<Object, Object> responseMap = new HashMap<>();

        String topic = requestMap.get("centra").toString();

        CompletableFuture<Object> completableFuture = CompletableFuture.supplyAsync(() -> {
            return controllerResponseResolver.resolveResponse(topic, principal, (Map<String, Object>) requestMap.get("request"));
        });

        responseMap.put("centra", topic);
        responseMap.put("response", completableFuture.get());

        session.sendMessage(new TextMessage(gson.toJson(responseMap)));
    }
}
