package cc.aisc.platform.commons.auth.service;

import cc.aisc.platform.commons.auth.entity.Group;
import cc.aisc.platform.commons.auth.entity.Role;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

/**
 * Created by sjf on 15-12-1.
 */
public interface GroupService {
    Optional<Group> getGroupById(Long id);

    Collection<Group> getAllGroups();

    Optional<Group> getGroupByGroupName(String groupname);

    Group create(Group obj);

    Group save(Group obj);

    Group add(Group obj);

    Group addRoles(Group group, Set<Role> roles);
    Group removeRoles(Group group, Set<Role> roles);
}
