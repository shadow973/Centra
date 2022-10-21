package dev.conductor.centra.domain.settings;

public enum DefaultSettingsEnum {
    INSTALLATION_COMPLETE("false"),
    INSTANCE_NAME("Centra"),
    PRIVATE_INSTANCE("true"),
    ALLOW_REGISTRATION("true"),
    LICENSE_KEY("");

    private final String settingsKey;

    DefaultSettingsEnum(String settingsKey) {
        this.settingsKey = settingsKey;
    }

    @Override
    public String toString(){
        return settingsKey;
    }
}
