package cc.aisc.platform.auth.user.dao;

import cc.aisc.platform.auth.user.entity.User;
import cc.aisc.platform.commons.base.BaseDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by sjf on 15-11-11.
 */
public interface UserDao extends JpaRepository<User, Long> {

    Optional<User> findOneByEmail(String email);
}