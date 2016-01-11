package cc.aisc.platform.commons.auth.user.service;

import cc.aisc.platform.commons.auth.user.entity.User;
import cc.aisc.platform.commons.auth.dto.UserCreateForm;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by sjf on 15-11-11.
 */
public interface UserService/* extends BaseService<User, Long>*/{

    /*private UserDao getUserDao(){
        return (UserDao)baseDao;
    }

    public Optional<User> getUserByEmail(String email){
        return getUserDao().findOneByEmail(email);
    }

    public Optional<User> getUserById(Long id){
        return Optional.ofNullable(getUserDao().findOne(id));
    }

    public Collection<User> getAllUsers(){
        return getUserDao().findAll(new Sort("email"));
    }

    public User create(UserCreateForm form){
        User user = new User(form.getEmail(),form.getPassword(),form.getRole());
        return getUserDao().save(user);
    }

    public User save(User user){
        Optional<User> u = getUserDao().findOneByEmail(user.getEmail());
        if(!u.isPresent())
            return getUserDao().save(user);
        return u.get();
    }*/
    Optional<User> getUserById(Long id);

    Optional<User> getUserByEmail(String email);

    Optional<User> getUserByUsername(String username);

    Collection<User> getAllUsers();

    User create(UserCreateForm form);

    User save(User user);

}
