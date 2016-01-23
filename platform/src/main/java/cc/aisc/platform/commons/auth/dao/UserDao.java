package cc.aisc.platform.commons.auth.dao;

import cc.aisc.platform.commons.auth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sjf on 15-11-11.
 */
public interface UserDao extends JpaRepository<User, Long> {
    User findOneByUsername(String username);

}