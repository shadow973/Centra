package dev.conductor.centra.domain.settings.api.impl;

import dev.conductor.centra.domain.settings.api.SettingsService;
import dev.conductor.centra.domain.settings.DefaultSettingsEnum;
import dev.conductor.centra.domain.settings.SettingsEnum;
import dev.conductor.centra.domain.settings.entity.Settings;
import dev.conductor.centra.domain.settings.spi.SettingsPersistencePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SettingsServiceAdapter implements SettingsService {

    @Autowired private SettingsPersistencePort persistencePort;

    @Override
    public Settings getSettingsByName(SettingsEnum name) {
        return persistencePort.findOneByKey(name.name());
    }

    @Override
    public List<Settings> findAll() {
        return persistencePort.findAll();
    }

    @Override
    public Settings getDefaultByName(SettingsEnum name) {
        return new Settings(name.name(), DefaultSettingsEnum.valueOf(name.name()).toString());
    }

    @Override
    public Settings save(Settings settings) {
        return persistencePort.save(settings);
    }
}
