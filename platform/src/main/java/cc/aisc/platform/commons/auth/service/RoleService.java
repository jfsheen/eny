package cc.aisc.platform.commons.auth.service;


import cc.aisc.platform.commons.auth.entity.Resource;
import cc.aisc.platform.commons.auth.entity.Role;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

/**
 * Created by sjf on 15-12-1.
 */
public interface RoleService {
    Optional<Role> getRoleById(Long id);

    Optional<Collection<Role>> getAllRoles();

    Optional<Role> getRoleByRoleName(String rolename);

    Role create(Role obj);

    Role save(Role obj);

    Role add(Role obj);

    Role addResources(Role obj, Set<Resource> resources);
    Role removeResources(Role obj, Set<Resource> resources);


}
