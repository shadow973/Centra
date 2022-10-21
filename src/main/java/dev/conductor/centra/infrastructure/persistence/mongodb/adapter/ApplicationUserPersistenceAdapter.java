package dev.conductor.centra.infrastructure.persistence.mongodb.adapter;

import dev.conductor.centra.domain.applicationUser.entity.ApplicationUser;
import dev.conductor.centra.domain.applicationUser.entity.UserGroup;
import dev.conductor.centra.domain.applicationUser.spi.ApplicationUserPersistencePort;
import dev.conductor.centra.infrastructure.persistence.mongodb.entity.ApplicationUserEntity;
import dev.conductor.centra.infrastructure.persistence.mongodb.entity.UserGroupEntity;
import dev.conductor.centra.infrastructure.persistence.mongodb.repository.ApplicationUserRepository;
import dev.conductor.centra.infrastructure.persistence.mongodb.repository.UserGroupRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Repository;
import org.springframework.cache.annotation.Cacheable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ApplicationUserPersistenceAdapter implements ApplicationUserPersistencePort {

    private final ModelMapper modelMapper;
    private final ApplicationUserRepository repository;
    private final UserGroupRepository userGroupRepository;

    @Autowired
    public ApplicationUserPersistenceAdapter(ApplicationUserRepository repository, ModelMapper modelMapper, UserGroupRepository userGroupRepository) {
        this.repository = repository;
        this.modelMapper = modelMapper;
        this.userGroupRepository = userGroupRepository;
    }

    @Override
    @Cacheable(value = "applicationUsers")
    public ApplicationUser findByUsername(String username) {
        ApplicationUserEntity entity = repository.findByUsername(username);

        if (entity != null) {
            return modelMapper.map(entity, ApplicationUser.class);
        }

        return null;
    }

    @Override
    @Cacheable(value = "applicationUsers")
    public List<ApplicationUser> findAll() {
        List<ApplicationUser> result = new ArrayList<>();

        for(ApplicationUserEntity entity: repository.findAll()){
            result.add(modelMapper.map(entity, ApplicationUser.class));
        }

        return result;
    }

    @Override
    @Cacheable(value = "applicationUsers")
    public ApplicationUser findByEmailAddress(String emailAddress) {
        ApplicationUserEntity entity = repository.findByEmailAddress(emailAddress);

        if (entity != null) {
            return modelMapper.map(entity, ApplicationUser.class);
        }

        return null;
    }

    @Override
    @Cacheable(value = "applicationUsers")
    public ApplicationUser findById(String id) {
        Optional<ApplicationUserEntity> entity = repository.findById(id);

        return entity.map(
                    applicationUserEntity -> modelMapper.map(applicationUserEntity, ApplicationUser.class)
                ).orElse(null);

    }

    @Override
    @CachePut(value = "applicationUsers", key = "#user.id", condition="#user.id != null")
    public ApplicationUser save(ApplicationUser user) {
        ApplicationUserEntity entity = modelMapper.map(user, ApplicationUserEntity.class);
        repository.save(entity);

        return modelMapper.map(entity, ApplicationUser.class);
    }

    @Override
    @Cacheable(value = "applicationUsersGroups")
    public UserGroup findGroupById(String id) {
        Optional<UserGroupEntity> entity = userGroupRepository.findById(id);

        return entity.map(
                userGroupEntity -> modelMapper.map(userGroupEntity, UserGroup.class)
        ).orElse(null);
    }

    @Override
    @CachePut(value = "applicationUsersGroups", key = "#group.id", condition="#group.id != null")
    public UserGroup saveGroup(UserGroup group) {
        UserGroupEntity entity = modelMapper.map(group, UserGroupEntity.class);
        userGroupRepository.save(entity);

        return modelMapper.map(entity, UserGroup.class);
    }

    @Override
    @Cacheable(value = "applicationUsersGroups")
    public UserGroup findGroupByName(String name) {
        UserGroupEntity entity = userGroupRepository.findByName(name);

        if (entity != null) {
            return modelMapper.map(entity, UserGroup.class);
        }

        return null;
    }
}
