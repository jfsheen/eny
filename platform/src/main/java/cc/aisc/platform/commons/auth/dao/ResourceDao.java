package cc.aisc.platform.commons.auth.dao;

import cc.aisc.platform.commons.auth.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sjf on 15-12-1.
 */
public interface ResourceDao extends JpaRepository<Resource, Long> {
    Resource findOneByFuncId(String funcId);
}
