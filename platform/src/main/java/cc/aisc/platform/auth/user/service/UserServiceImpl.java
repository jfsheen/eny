package cc.aisc.platform.auth.user.service;

import cc.aisc.platform.auth.user.entity.User;
import cc.aisc.platform.auth.user.entity.UserCreateForm;
import cc.aisc.platform.auth.user.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by sjf on 15-11-11.
 */
@Service
public class UserServiceImpl implements UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Optional<User> getUserById(Long id) {
        LOGGER.debug("Getting user={}", id);
        return Optional.ofNullable(userDao.findOne(id));
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        LOGGER.debug("Getting user by email={}", email.replaceFirst("@.*", "@***"));
        return userDao.findOneByEmail(email);
    }

    @Override
    public Collection<User> getAllUsers() {
        LOGGER.debug("Getting all users");
        return userDao.findAll(new Sort("email"));
    }

    @Override
    public User create(UserCreateForm form) {
        User user = new User(form.getEmail(),form.getPassword(),form.getRole());
        return userDao.save(user);
    }

    @Override
    public User save(User user) {
        Optional<User> u = userDao.findOneByEmail(user.getEmail());
        if(!u.isPresent())
            return userDao.save(user);
        return u.get();
    }
}
