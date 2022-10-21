package dev.conductor.centra.application.security.social;

import dev.conductor.centra.domain.applicationUser.entity.ApplicationUser;
import dev.conductor.centra.application.security.social.util.UserHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.stereotype.Service;

@Service
public class SocialConnectionSignup implements ConnectionSignUp {
    @Autowired UserHelper userHelper;

    @Override
    public String execute(Connection<?> connection)
    {
        ApplicationUser user = userHelper.getUser(connection);

        return user.getUsername();
    }
}
