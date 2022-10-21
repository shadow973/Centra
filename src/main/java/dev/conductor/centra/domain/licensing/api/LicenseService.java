package dev.conductor.centra.domain.licensing.api;

import dev.conductor.centra.domain.licensing.License;

public interface LicenseService {

    License getLicense();
    License saveLicense(String licenseKey);

}
