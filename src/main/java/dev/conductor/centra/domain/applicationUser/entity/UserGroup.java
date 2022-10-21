package dev.conductor.centra.domain.applicationUser.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class UserGroup implements Serializable {

    public static final String CENTRA_USERS = "centra-users";
    public static final String CENTRA_ADMINISTRATORS = "centra-administrators";

    private String id;
    private String name;
}
