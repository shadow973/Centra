package dev.conductor.centra.infrastructure.persistence.mongodb.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Document(collection = "users")
public class ApplicationUserEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    @Indexed(unique=true)
    private String username;
    @Indexed(unique=true)
    private String emailAddress;
    private String password;
    private String displayName;
    private Boolean admin;
    private Boolean enabled;
    @DBRef
    private Set<UserGroupEntity> userGroups = new HashSet<>();
}
