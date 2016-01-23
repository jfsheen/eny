package cc.aisc.platform.commons.auth.service;

import cc.aisc.platform.commons.auth.entity.Group;
import cc.aisc.platform.commons.auth.dao.GroupDao;
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
public class GroupServiceImpl extends BaseService implements GroupService{

    private final GroupDao groupDao;

    @Autowired
    public GroupServiceImpl(GroupDao groupDao) {
        this.groupDao = groupDao;
    }

    @Override
    public Optional<Group> getGroupById(Long id) {
        LOGGER.debug("Getting group={}", id);
        return Optional.ofNullable(groupDao.findOne(id));
    }


    @Override
    public Optional<Group> getGroupByGroupName(String groupname) {
        LOGGER.debug("Getting group by Groupname = {}", groupname);
        return Optional.ofNullable(groupDao.findOneByGroupName(groupname));
    }

    @Override
    public Collection<Group> getAllGroups() {
        LOGGER.debug("Getting all groups");
        return groupDao.findAll();
    }

    @Override
    public Group save(Group obj) {
        if(null != obj) {
            Optional<Group> oo = Optional.ofNullable(groupDao.findOneByGroupName(obj.getGroupName()));
            if (oo.isPresent()) {
                Group group = oo.get();
                BeanUtils.copyPropertiesIgnoreNull(obj, group);
                return groupDao.save(group);
            }else {
                return groupDao.save(obj);
            }
        }
        return null;
    }

    @Override
    public Group create(Group obj) {
        return save(obj);
    }

    @Override
    public Group add(Group obj) {
        return save(obj);
    }

    @Override
    public Group addRoles(Group obj, Set<Role> roles) {
        if(null != obj) {
            Optional<Group> oo = Optional.ofNullable(groupDao.findOneByGroupName(obj.getGroupName()));
            if(oo.isPresent()) {
                Group group = oo.get();
                group.getRoles().addAll(roles);
                return groupDao.save(group);
            }
        }
        return null;
    }

    @Override
    public Group removeRoles(Group obj, Set<Role> roles) {
        if(null != obj) {
            Optional<Group> oo = Optional.ofNullable(groupDao.findOneByGroupName(obj.getGroupName()));
            if (oo.isPresent()) {
                Group group = oo.get();
                for (Role role : roles){
                    group.getRoles().remove(role);
                }
                return groupDao.save(group);
            }
        }
        return null;
    }
}
