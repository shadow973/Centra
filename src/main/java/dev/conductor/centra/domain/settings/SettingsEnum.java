package dev.conductor.centra.domain.settings;

import java.util.HashMap;
import java.util.Map;

public enum SettingsEnum {
    INSTALLATION_COMPLETE("instance.installation_complete"),
    INSTANCE_NAME("instance.public_name"),
    PRIVATE_INSTANCE("instance.private"),
    ALLOW_REGISTRATION("instance.registration.enabled"),
    LICENSE_KEY("instance.license_key");

    private final String settingsKey;
    private static final Map<String, SettingsEnum> map = new HashMap<>();

    private SettingsEnum(String settingsKey) {
        this.settingsKey = settingsKey;
    }

    @Override
    public String toString(){
        return settingsKey;
    }

    static {
        for (SettingsEnum settingsEnum : SettingsEnum.values()) {
            map.put(settingsEnum.toString(), settingsEnum);
        }
    }

    public static SettingsEnum getByValue(String searchedString) {
        return map.get(searchedString);
    }
}
