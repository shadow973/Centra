package dev.conductor.centra.application.controllers;

import dev.conductor.centra.domain.customField.api.CustomFieldService;
import dev.conductor.centra.domain.customField.dto.CustomFieldValueWithCustomFieldDTO;
import dev.conductor.centra.domain.customField.entity.CustomField;
import dev.conductor.centra.domain.customField.entity.CustomFieldValue;
import dev.conductor.centra.domain.issue.entity.Issue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/customfields")
public class CustomFieldsController extends BaseController {

    private final CustomFieldService service;

    @Autowired
    public CustomFieldsController(CustomFieldService service) {
        this.service = service;
    }

    @PostMapping()
    public CustomField createCustomField(@RequestBody CustomField customField, Principal principal) {

        if (!isAdmin(principal)){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }

        return service.createCustomField(customField);
    }

    @GetMapping("/{id}")
    public CustomField getCustomFieldById(@PathVariable String id) {
        return service.getCustomFieldById(id);
    }

    @GetMapping("/issue/{id}")
    public List<CustomFieldValueWithCustomFieldDTO> getCustomFieldValuesForIssues(@PathVariable String id) {
        return service.getCustomFieldValuesForIssue(getIssueByExternalId(id))
                .stream()
                .map(customFieldValue -> new CustomFieldValueWithCustomFieldDTO(
                        service.getCustomFieldById(customFieldValue.getCustomFieldId()),
                        customFieldValue
                ))
                .collect(Collectors.toList());
    }

    @PostMapping("/issue/{id}")
    public CustomFieldValue saveCustomFieldValue(@RequestBody CustomFieldValue value, @PathVariable String id) {
        Issue issue = getIssueByExternalId(id);
        CustomField customField = service.getCustomFieldById(value.getCustomFieldId());

        if (customField == null) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Custom Field not found!");
        }

        if (customField.getProjectId() != null && !customField.getProjectId().equals(issue.getProjectId())) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Custom Field not a part of the issue's project");
        }

        try {
            return service.saveValue(issue, value);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, e.getMessage());
        }
    }

}
