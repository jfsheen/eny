package cc.aisc.platform.commons.auth.user.dao;

import cc.aisc.platform.commons.auth.user.entity.UserGroup;
import org.hibernate.metamodel.source.binder.JpaCallbackClass;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sjf on 15-12-1.
 */
public interface UserGroupDao extends JpaRepository<UserGroup, Long> {

}
