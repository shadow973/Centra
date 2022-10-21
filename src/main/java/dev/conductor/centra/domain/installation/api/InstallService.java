package dev.conductor.centra.domain.installation.api;

import dev.conductor.centra.domain.installation.dto.InstallationDTO;

public interface InstallService {
    void install(InstallationDTO installationDTO);
}
