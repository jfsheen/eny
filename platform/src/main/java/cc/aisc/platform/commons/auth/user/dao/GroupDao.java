package cc.aisc.platform.commons.auth.user.dao;

import cc.aisc.platform.commons.auth.user.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sjf on 15-12-1.
 */
public interface GroupDao extends JpaRepository<Group, Long> {
}
