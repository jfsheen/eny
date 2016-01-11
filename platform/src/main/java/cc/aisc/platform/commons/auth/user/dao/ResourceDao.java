package cc.aisc.platform.commons.auth.user.dao;

import cc.aisc.platform.commons.auth.user.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sjf on 15-12-1.
 */
public interface ResourceDao extends JpaRepository<Resource, Long> {
}
