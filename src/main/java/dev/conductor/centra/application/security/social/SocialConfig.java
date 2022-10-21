package dev.conductor.centra.application.security.social;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.social.UserIdSource;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurer;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.connect.mem.InMemoryUsersConnectionRepository;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.social.connect.web.ProviderSignInController;
import org.springframework.social.google.connect.GoogleConnectionFactory;
import org.springframework.social.security.AuthenticationNameUserIdSource;

import javax.inject.Inject;
import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:application.properties")
@EnableSocial
public class SocialConfig implements SocialConfigurer {
    @Autowired
    //private DataSource dataSource;
    private Environment environment;

    public void addConnectionFactories(ConnectionFactoryConfigurer connectionFactoryConfigurer) {
        GoogleConnectionFactory googleConnectionFactory = new GoogleConnectionFactory(environment.getProperty("spring.social.google.appId"), environment.getProperty("spring.social.google.appSecret"));
        googleConnectionFactory.setScope("profile");
    }

    public UserIdSource getUerIdSource() {
        return new UserIdSource() {
            @Override
            public String getUserId() {
                Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
                if(authentication == null) {
                    throw new IllegalStateException("Unable to get a ConnectionRepository: no user signed in");
                }
                return authentication.getName();
            }
        };
    }

    @Override
    public void addConnectionFactories(ConnectionFactoryConfigurer connectionFactoryConfigurer, Environment environment) {

    }

    @Override
    public UserIdSource getUserIdSource() {
        return null;
    }

    @Override
    public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
        InMemoryUsersConnectionRepository usersConnectionRepository = new InMemoryUsersConnectionRepository(
                connectionFactoryLocator);
        return usersConnectionRepository;
    }
}
