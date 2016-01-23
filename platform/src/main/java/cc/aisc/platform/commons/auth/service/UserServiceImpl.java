package cc.aisc.platform.commons.auth.service;

import cc.aisc.platform.commons.auth.dao.GroupDao;
import cc.aisc.platform.commons.auth.dao.ResourceDao;
import cc.aisc.platform.commons.auth.dao.RoleDao;
import cc.aisc.platform.commons.auth.dao.UserDao;
import cc.aisc.platform.commons.auth.dto.UserDto;
import cc.aisc.platform.commons.auth.entity.Group;
import cc.aisc.platform.commons.auth.entity.Resource;
import cc.aisc.platform.commons.auth.entity.Role;
import cc.aisc.platform.commons.auth.entity.User;
import cc.aisc.platform.commons.base.BaseService;
import cc.aisc.platform.constant.Constant;
import cc.aisc.platform.utils.BeanUtils;
import cc.aisc.platform.utils.StringUtils;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

/**
 * Created by sjf on 15-11-11.
 */
@Service
@Transactional
public class UserServiceImpl extends BaseService<User> implements UserService {

    private final UserDao userDao;
    private final GroupDao groupDao;
    private final ResourceDao resourceDao;
    private final RoleDao roleDao;

    @Autowired
    public UserServiceImpl(UserDao userDao, GroupDao groupDao, ResourceDao resourceDao, RoleDao roleDao) {
        this.userDao = userDao;
        this.groupDao = groupDao;
        this.resourceDao = resourceDao;
        this.roleDao = roleDao;
    }

    @Override
    public Optional<User> getUserById(Long id) {
        LOGGER.debug("Getting user={}", id);
        return Optional.ofNullable(userDao.findOne(id));
    }


    @Override
    public Optional<User> getUserByUsername(String username) {
        LOGGER.debug("Getting user by Username = {}", username);
        return Optional.ofNullable(userDao.findOneByUsername(username));
    }

    @Override
    public Collection<User> getAllUsers() {
        LOGGER.debug("Getting all users");
        return userDao.findAll(new Sort("username"));
    }

    @Override
    public User create(UserDto obj) {
        if (null != obj) {
            User user = new User(obj.getUsername(), obj.getPasswordHash());
            if (null != obj.getDateExpired())
                user.setDateExpired(obj.getDateExpired());
            user.setEnabled(null != obj.getEnabled()?obj.getEnabled():false);
            user.setNonLocked(null != obj.getNonLocked() ? obj.getNonLocked():false);
            return save(user);
        }
        return null;
    }

    private User saveOrUpdate(Optional<User> o){

        return null;
    }

    @Override
    public User save(User obj) {
        if(null != obj) {
            Optional<User> oo = Optional.ofNullable(userDao.findOneByUsername(obj.getUsername()));
            if(oo.isPresent()){
                User user = oo.get();
                BeanUtils.copyPropertiesIgnoreNull(obj, user);
                return userDao.save(user);
            }else{
                return userDao.save(obj);
            }
        }
        return null;
    }


   /* @Override
    public String [] getAuthorities(User obj) {
        List<String> authorities = new ArrayList<String>();
        if (null != obj){
            Optional<User> oo = Optional.ofNullable(userDao.findOneByUsername(obj.getUsername()));
            if(oo.isPresent()){
                User user = oo.get();
                for (Group group : user.getGroups()){
                    for(Role role: group.getRoles()){
                            if (!authorities.contains(role.toAuthority()))
                                authorities.add(role.toAuthority());
                    }
                }
            }
        }
        return authorities.toArray(new String[authorities.size()]);
    }*/

    @Override
    public User addGroups(User obj, Set<Group> groups) {
        if(null != obj) {
            Optional<User> oo = Optional.ofNullable(userDao.findOneByUsername(obj.getUsername()));
            if(oo.isPresent()) {
                User user = oo.get();
                user.getGroups().addAll(groups);
                return userDao.save(user);
            }
        }
        return null;
    }

    @Override
    public User removeGroups(User obj, Set<Group> groups) {
        if(null != obj) {
            Optional<User> oo = Optional.ofNullable(userDao.findOneByUsername(obj.getUsername()));
            if (oo.isPresent()) {
                User user = oo.get();
                for (Group group : groups){
                    user.getGroups().remove(group);
                }
                return userDao.save(user);
            }
        }
        return null;
    }

    @Override
    public User addRoles(User obj, Set<Role> roles) {
        if(null != obj) {
            Optional<User> oo = Optional.ofNullable(userDao.findOneByUsername(obj.getUsername()));
            if(oo.isPresent()) {
                User user = oo.get();
                user.getRoles().addAll(roles);
                return userDao.save(user);
            }
        }
        return null;
    }

    @Override
    public User removeRoles(User obj, Set<Role> roles) {
        if(null != obj) {
            Optional<User> oo = Optional.ofNullable(userDao.findOneByUsername(obj.getUsername()));
            if (oo.isPresent()) {
                User user = oo.get();
                for (Role role : roles){
                    user.getRoles().remove(role);
                }
                return userDao.save(user);
            }
        }
        return null;
    }


}
