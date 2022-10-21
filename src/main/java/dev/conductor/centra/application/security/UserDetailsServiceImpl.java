package dev.conductor.centra.application.security;

import dev.conductor.centra.domain.applicationUser.api.ApplicationUserService;
import dev.conductor.centra.domain.applicationUser.entity.ApplicationUser;
import dev.conductor.centra.domain.applicationUser.entity.UserGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    ApplicationUserService service;

    @Override
    public UserDetails loadUserByUsername(String username) {
        ApplicationUser applicationUser = service.findByUsername(username);

        if (applicationUser == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(applicationUser.getUsername(), applicationUser.getPassword(), getUserAuthority(applicationUser.getUserGroups()));
    }

    private List<GrantedAuthority> getUserAuthority(Set<UserGroup> userGroups) {
        Set<GrantedAuthority> authorities = new HashSet<>();
        userGroups.forEach(group -> authorities.add(new SimpleGrantedAuthority(group.getName())));

        return new ArrayList<>(authorities);
    }
}
