package cc.aisc.platform.commons.auth.service;

import cc.aisc.platform.commons.auth.dao.RoleDao;
import cc.aisc.platform.commons.auth.dao.ResourceDao;
import cc.aisc.platform.commons.auth.entity.Resource;
import cc.aisc.platform.commons.auth.entity.Role;
import cc.aisc.platform.commons.base.BaseService;
import cc.aisc.platform.utils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

/**
 * Created by sjf on 15-12-1.
 */
@Service
public class RoleServiceImpl extends BaseService implements RoleService {

    private final RoleDao roleDao;
    private final ResourceDao resourceDao;

    @Autowired
    public RoleServiceImpl(RoleDao roleDao, ResourceDao resourceDao) {
        this.roleDao = roleDao;
        this.resourceDao = resourceDao;
    }


    @Override
    public Optional<Role> getRoleById(Long id) {
        return Optional.ofNullable(roleDao.findOne(id));
    }

    @Override
    public Optional<Collection<Role>> getAllRoles() {
        return Optional.ofNullable(roleDao.findAll());
    }

    @Override
    public Optional<Role> getRoleByRoleName(String rolename) {
        return Optional.ofNullable(roleDao.findOneByRoleName(rolename));
    }

    @Override
    public Role save(Role obj) {
        if(null != obj) {
            Optional<Role> oo = Optional.ofNullable(roleDao.findOneByRoleName(obj.getRoleName()));
            if (oo.isPresent()) {
                Role role = oo.get();
                BeanUtils.copyPropertiesIgnoreNull(obj, role);
                return roleDao.save(role);// role exists already;
            }else{
                return roleDao.save(obj); // new role ;
            }
        }
        return null;
    }

    @Override
    public Role add(Role obj) {
        return save(obj);
    }

    @Override
    public Role create(Role obj) {
        return save(obj);
    }

    @Override
    public Role addResources(Role obj, Set<Resource> resources) {
        if(null != obj) {
            Optional<Role> oo = Optional.ofNullable(roleDao.findOneByRoleName(obj.getRoleName()));
            if(oo.isPresent()) {
                Role role = oo.get();
                role.getResources().addAll(resources);
                return roleDao.save(role);
            }
        }
        return null;
    }

    @Override
    public Role removeResources(Role obj, Set<Resource> resources) {
        if(null != obj) {
            Optional<Role> oo = Optional.ofNullable(roleDao.findOneByRoleName(obj.getRoleName()));
            if (oo.isPresent()) {
                Role role = oo.get();
                for (Resource resource : resources){
                    role.getResources().remove(resource);
                }
                return roleDao.save(role);
            }
        }
        return null;
    }


    
}
