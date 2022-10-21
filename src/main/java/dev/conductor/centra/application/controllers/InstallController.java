package dev.conductor.centra.application.controllers;

import dev.conductor.centra.domain.installation.api.InstallService;
import dev.conductor.centra.domain.installation.dto.InstallationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/install")
public class InstallController {

    @Autowired
    InstallService installService;

    @PostMapping()
    public void install(@RequestBody InstallationDTO installationDTO) {
        installService.install(installationDTO);
    }
}
