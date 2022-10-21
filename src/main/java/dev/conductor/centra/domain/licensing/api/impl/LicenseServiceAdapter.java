package dev.conductor.centra.domain.licensing.api.impl;

import dev.conductor.centra.domain.licensing.License;
import dev.conductor.centra.domain.licensing.LicenseDecoder;
import dev.conductor.centra.domain.licensing.api.LicenseService;
import dev.conductor.centra.domain.settings.SettingsEnum;
import dev.conductor.centra.domain.settings.entity.Settings;
import dev.conductor.centra.domain.settings.api.SettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LicenseServiceAdapter implements LicenseService {

    @Autowired
    SettingsService settingsService;

    @Autowired
    LicenseDecoder licenseDecoder;

    @Override
    public License getLicense() {
        Settings licenseKey = settingsService.getSettingsByName(SettingsEnum.LICENSE_KEY);

        if (licenseKey == null || licenseKey.getValue() == null){
            return null;
        }

        return licenseDecoder.decode(licenseKey.getValue());
    }

    @Override
    public License saveLicense(String licenseKey) {
        License decoded = licenseDecoder.decode(licenseKey);
        Settings licenseKeySettings = settingsService.getSettingsByName(SettingsEnum.LICENSE_KEY);
        licenseKeySettings.setValue(licenseKey);

        settingsService.save(licenseKeySettings);

        return decoded;
    }
}
