package dev.conductor.centra.domain.applicationUser.api;

import dev.conductor.centra.domain.applicationUser.dto.UserLiteDTO;
import dev.conductor.centra.domain.applicationUser.entity.ApplicationUser;
import dev.conductor.centra.domain.applicationUser.entity.UserGroup;

import java.util.List;

public interface ApplicationUserService {

    List<ApplicationUser> findAll();
    ApplicationUser save(ApplicationUser user);
    ApplicationUser findByUsername(String username);
    ApplicationUser findByEmailAddress(String emailAddress);
    ApplicationUser findById(String id);
    ApplicationUser createUser(ApplicationUser user, boolean admin);
    Boolean isAdmin(ApplicationUser user);
    void changePassword(ApplicationUser user, String password);
    List<UserLiteDTO> findAllLite();
    UserLiteDTO findByUsernameLite(String username);
    UserGroup saveGroup(UserGroup group);
    UserGroup findGroupById(String id);
    UserGroup findGroupByName(String name);
}
