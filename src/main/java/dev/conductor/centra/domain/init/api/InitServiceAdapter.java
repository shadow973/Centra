package dev.conductor.centra.domain.init.api;

import dev.conductor.centra.domain.settings.SettingsEnum;
import dev.conductor.centra.domain.init.dto.InitDTO;
import dev.conductor.centra.domain.settings.entity.Settings;
import dev.conductor.centra.domain.applicationUser.api.ApplicationUserService;
import dev.conductor.centra.domain.settings.api.SettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.*;

@Service
public class InitServiceAdapter implements InitService {

    @Autowired
    private SettingsService settingsService;

    @Autowired
    private ApplicationUserService userService;

    @Override
    public InitDTO getInit(Principal principal) {
        Map<SettingsEnum, String> settingsValues = getSettingsValues(initValues());

        return new InitDTO(
                Boolean.valueOf(settingsValues.get(SettingsEnum.ALLOW_REGISTRATION)),
                Boolean.valueOf(settingsValues.get(SettingsEnum.PRIVATE_INSTANCE)),
                Boolean.valueOf(settingsValues.get(SettingsEnum.INSTALLATION_COMPLETE)),
                settingsValues.get(SettingsEnum.INSTANCE_NAME),
                principal != null ? userService.findByUsernameLite(principal.getName()) : null
        );
    }

    private Map<SettingsEnum, String> getSettingsValues(List<SettingsEnum> settingsEnumList) {
        List<Settings> settingVals = settingsService.findAll();

        Map<SettingsEnum, String> map = new HashMap<>();

        settingsEnumList.forEach(se -> {
            Optional<Settings> settings = settingVals.stream().filter(s -> s.getKey().equals(se.name())).findFirst();
            map.put(se, settings.isPresent() ? settings.get().getValue() : settingsService.getDefaultByName(se).getValue());
        });

        return map;
    }

    private List<SettingsEnum> initValues() {
        return List.of(
                SettingsEnum.ALLOW_REGISTRATION,
                SettingsEnum.PRIVATE_INSTANCE,
                SettingsEnum.INSTALLATION_COMPLETE,
                SettingsEnum.INSTANCE_NAME
        );
    }
}
