package dev.conductor.centra.application.security;

import dev.conductor.centra.domain.settings.SettingsEnum;
import dev.conductor.centra.domain.settings.entity.Settings;
import dev.conductor.centra.domain.settings.api.SettingsService;
import dev.conductor.centra.application.security.social.SocialConnectionSignup;
import dev.conductor.centra.application.security.social.SocialSignInAdapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.mem.InMemoryUsersConnectionRepository;
import org.springframework.social.connect.web.ProviderSignInController;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
    @Autowired private UserDetailsServiceImpl userService;
    @Autowired private SettingsService settingsService;
    @Autowired private UsersConnectionRepository usersConnectionRepository;
    @Autowired private ConnectionFactoryLocator connectionFactoryLocator;
    @Autowired private SocialConnectionSignup socialConnectionSignup;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        Settings privateInstance = settingsService.getSettingsByName(SettingsEnum.PRIVATE_INSTANCE);

        if (privateInstance == null || privateInstance.getValue().equals("false")){
            http.cors().and().csrf().disable().authorizeRequests()
                    .antMatchers(HttpMethod.GET).permitAll();
        }

        http.cors().and().csrf().disable().authorizeRequests()
                .antMatchers(HttpMethod.POST, SecurityConstants.SIGN_UP_URL).permitAll()
                .antMatchers(HttpMethod.POST, "/error").permitAll()
                .antMatchers(HttpMethod.GET, "/**").permitAll()
                .antMatchers(HttpMethod.GET, "/api/**").denyAll()
                .antMatchers(HttpMethod.GET, "/main.js").permitAll()
                .antMatchers(HttpMethod.GET, "/login").permitAll()
                .antMatchers(HttpMethod.GET, "/install").permitAll()
                .antMatchers(HttpMethod.GET, "/browse/**").permitAll()
                .antMatchers(HttpMethod.GET, "/search").permitAll()
                .antMatchers(HttpMethod.GET, "/actuator/health").permitAll()
                .antMatchers(HttpMethod.GET, "/init").permitAll()
                .antMatchers(HttpMethod.GET, "/swagger-ui/*").permitAll()
                .antMatchers(HttpMethod.GET, "/swagger-resources/**").permitAll()
                .antMatchers(HttpMethod.GET, "/v3/api-docs").permitAll()
                .antMatchers(HttpMethod.POST, "/api/login").permitAll()
                .antMatchers(HttpMethod.POST, "/api/users").permitAll()
                .antMatchers(HttpMethod.POST, "/api/install").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .addFilter(new JWTAuthenticationFilter(authenticationManager()))
                .addFilter(new JWTAuthorizationFilter(authenticationManager()))
                // this disables session creation on Spring Security
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .logout().permitAll()
        ;
        http.exceptionHandling().authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED));
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration configuration = new CorsConfiguration();
        List<String> allowedOriginPatterns = new ArrayList<>();
        allowedOriginPatterns.add("*");
        configuration.setAllowedOriginPatterns(allowedOriginPatterns);
        configuration.setAllowedMethods(Arrays.asList("HEAD",
                "GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS"));
        configuration.setAllowCredentials(true);
        configuration.setAllowedHeaders(Arrays.asList("Content-Type", "X-Auth-Token","Authorization","Access-Control-Allow-Origin","Access-Control-Allow-Credentials"));
        configuration.setExposedHeaders(Arrays.asList("Content-Type", "X-Auth-Token","Authorization","Access-Control-Allow-Origin","Access-Control-Allow-Credentials"));
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public ProviderSignInController providerSignInController()
    {
        ((InMemoryUsersConnectionRepository) usersConnectionRepository)
                .setConnectionSignUp(socialConnectionSignup);

        return new ProviderSignInController(
                connectionFactoryLocator,
                usersConnectionRepository,
                new SocialSignInAdapter());
    }
}