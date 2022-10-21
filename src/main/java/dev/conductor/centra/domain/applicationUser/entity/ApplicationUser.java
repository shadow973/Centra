package dev.conductor.centra.domain.applicationUser.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class ApplicationUser implements Serializable {

    private String id;
    private String username;
    private String emailAddress;
    private String password;
    private String displayName;
    private Boolean admin;
    private Boolean enabled;
    private Set<UserGroup> userGroups = new HashSet<>();
}
