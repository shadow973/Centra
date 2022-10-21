package dev.conductor.centra.application.websocket;

import java.security.Principal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.conductor.centra.application.controllers.*;

@Component
public class ControllerResponseResolver {

    @Autowired
    private InitController initController;
    @Autowired
    private ProjectController projectController;

    public Object resolveResponse(String topic, Principal principal, Map<String, Object> request) {
        try {
            return switch (topic) {
                case "get/init" -> initController.getInit(principal);
                case "get/project/all" -> projectController.listAll();
                case "get/project/issuetypes" -> projectController.getIssueTypesForProject(request.get("id").toString());
                case "get/project/priorities" -> projectController.getPrioritiesForProject(request.get("id").toString());
                default -> null;
            };
        } catch (RuntimeException ex) {
            return ex.getMessage();
        }
    }
}
