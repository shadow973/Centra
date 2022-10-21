package dev.conductor.centra.domain.applicationUser.dto;

public class UserLiteDTO {

    private final String id;
    private final String displayName;
    private final String username;
    private final Boolean admin;

    public UserLiteDTO(String id, String displayName, String username, Boolean admin) {
        this.id = id;
        this.displayName = displayName;
        this.username = username;
        this.admin = admin;
    }

    public String getId() {
        return id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getUsername() {
        return username;
    }

    public Boolean getAdmin() {
        return admin;
    }
}
