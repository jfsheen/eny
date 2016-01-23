package cc.aisc.platform.commons.auth.service;

import cc.aisc.platform.commons.auth.dto.UserDto;
import cc.aisc.platform.commons.auth.entity.Group;
import cc.aisc.platform.commons.auth.entity.Resource;
import cc.aisc.platform.commons.auth.entity.Role;
import cc.aisc.platform.commons.auth.entity.User;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Created by sjf on 15-11-11.
 */
public interface UserService{

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

    public User create(UserDto form){
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

    Optional<User> getUserByUsername(String username);

    Collection<User> getAllUsers();

    User create(UserDto obj);

    User save(User obj);

    //String [] getAuthorities(User obj);

    User addGroups(User obj, Set<Group> groups);

    User removeGroups(User obj, Set<Group> groups);

    User addRoles(User obj, Set<Role> roles);

    User removeRoles(User obj, Set<Role> roles);

}
