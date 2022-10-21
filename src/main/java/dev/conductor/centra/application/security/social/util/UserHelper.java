package dev.conductor.centra.application.security.social.util;

import dev.conductor.centra.domain.applicationUser.entity.ApplicationUser;

import org.springframework.social.connect.Connection;
import org.springframework.social.google.api.Google;
import org.springframework.stereotype.Component;

@Component
public class UserHelper {
    public ApplicationUser getUser(Connection<?> connection)
    {
        ApplicationUser user = getGoogleUser(connection);

        return user;
    }

    private ApplicationUser getGoogleUser(Connection<?> connection)
    {
        ApplicationUser user = new ApplicationUser();
        Google googleApi = (Google) connection.getApi();
        String username = googleApi.plusOperations().getGoogleProfile().getGivenName() + googleApi.plusOperations().getGoogleProfile().getFamilyName();
        String name = googleApi.plusOperations().getGoogleProfile().getDisplayName();
        String email = googleApi.plusOperations().getGoogleProfile().getAccountEmail();
        user.setUsername(username);
        user.setDisplayName(name);
        user.setEmailAddress(email);
        user.setEnabled(true);
        return user;
    }
}
