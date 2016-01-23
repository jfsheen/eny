package cc.aisc.platform.commons.auth.dao;

import cc.aisc.platform.commons.auth.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sjf on 15-12-1.
 */
public interface RoleDao extends JpaRepository<Role, Long> {
    Role findOneByRoleName(String roleName);
}
