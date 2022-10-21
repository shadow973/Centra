package dev.conductor.centra.application.controllers;

import dev.conductor.centra.domain.settings.SettingsEnum;
import dev.conductor.centra.domain.settings.dto.SettingValueDTO;
import dev.conductor.centra.domain.settings.entity.Settings;
import dev.conductor.centra.domain.settings.api.SettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.EnumSet;
import java.util.HashMap;

@RestController
@RequestMapping("/api/settings")
public class SettingsController extends BaseController {

    @Autowired
    private SettingsService settingsService;

    @GetMapping
    public HashMap<String, String> listAll(Principal principal) {
        HashMap<String, String> map = new HashMap<>();

        if (!isAdmin(principal)){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }

        EnumSet<SettingsEnum> definitions = EnumSet.allOf(SettingsEnum.class);

        for (SettingsEnum settings: definitions) {
            map.put(settings.toString(), getSettings(settings));
        }

        return map;
    }

    @PutMapping("/{key}")
    public void setSettingsValue(@RequestBody SettingValueDTO dto,  @PathVariable String key, Principal principal) {
        if (!isAdmin(principal)){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }

        SettingsEnum setting = SettingsEnum.getByValue(key);

        if (setting == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Setting not found");
        }

        Settings settings = settingsService.getSettingsByName(setting);
        settings.setValue(dto.getValue());

        if (setting.equals(SettingsEnum.LICENSE_KEY)){
            /* validate license; */
        }

        settingsService.save(settings);
    }

    private String getSettings(SettingsEnum settings) {
        Settings retrievedValue = settingsService.getSettingsByName(settings);

        if (retrievedValue == null) {
            return settingsService.getDefaultByName(settings).getValue();
        }

        return retrievedValue.getValue();
    }
}
