package dev.conductor.centra.domain.licensing;

public interface LicenseDecoder {

    License decode(String licenseString);
}
