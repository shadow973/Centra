package dev.conductor.centra.domain.installation.api;

import dev.conductor.centra.domain.settings.SettingsEnum;
import dev.conductor.centra.domain.applicationUser.api.ApplicationUserService;
import dev.conductor.centra.domain.installation.dto.InstallationDTO;
import dev.conductor.centra.domain.applicationUser.entity.ApplicationUser;
import dev.conductor.centra.domain.settings.entity.Settings;
import dev.conductor.centra.domain.licensing.api.LicenseService;
import dev.conductor.centra.domain.settings.api.SettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class InstallServiceAdapter implements InstallService {

    @Autowired
    SettingsService settingsService;

    @Autowired
    ApplicationUserService userService;

    @Autowired
    LicenseService licenseService;

    @Override
    public void install(InstallationDTO installationDTO) {
        Settings installComplete;
        installComplete = settingsService.getSettingsByName(SettingsEnum.INSTALLATION_COMPLETE);

        if (!installComplete.getValue().equals("false")) {
            throw new ResponseStatusException(
                    HttpStatus.FORBIDDEN,
                    "Installation is already complete"
            );
        }

//        if (installationDTO.getLicenseKey() != null) {
//            licenseService.saveLicense(installationDTO.getLicenseKey());
//        }

        ApplicationUser user = new ApplicationUser();
        user.setDisplayName(installationDTO.getUsername());
        user.setEnabled(true);
        user.setEmailAddress("");
        user.setPassword(installationDTO.getPassword());
        user.setUsername(installationDTO.getUsername());

        userService.createUser(user, true);

        installComplete.setValue("true");
        settingsService.save(installComplete);
    }
}
