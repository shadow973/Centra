package dev.conductor.centra.domain.init.api;

import dev.conductor.centra.domain.init.dto.InitDTO;

import java.security.Principal;

public interface InitService {
    InitDTO getInit(Principal principal);
}
