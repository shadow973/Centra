package dev.conductor.centra.infrastructure.persistence.mongodb.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "settings")
public class SettingsEntity {

    @Id
    private String id = null;
    @Indexed(unique=true)
    private String key;
    private String value;

    public SettingsEntity() {}

    public SettingsEntity(String key, String value) {
        this.key = key;
        this.value = value;
    }


    @Override
    public String toString() {
        return value;
    }

}
