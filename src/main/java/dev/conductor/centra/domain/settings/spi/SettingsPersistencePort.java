package dev.conductor.centra.domain.settings.spi;

import dev.conductor.centra.domain.settings.entity.Settings;

import java.util.List;

public interface SettingsPersistencePort {

    Settings findOneByKey(String key);
    List<Settings> findAll();
    Settings save(Settings settings);
}
