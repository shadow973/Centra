package dev.conductor.centra.domain.label.spi;

import java.util.List;

public interface LabelPersistencePort {
    List<String> findAll();
}
