package cc.aisc.platform.commons.auth.service;

import cc.aisc.platform.commons.auth.dao.ResourceDao;
import cc.aisc.platform.commons.auth.entity.Resource;
import cc.aisc.platform.commons.base.BaseService;
import cc.aisc.platform.utils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;

/**
 * Created by sjf on 15-12-1.
 */
@Service
@Transactional
public class ResourceServiceImpl implements ResourceService {

    private final ResourceDao resourceDao;

    @Autowired
    public ResourceServiceImpl(ResourceDao resourceDao) {
        this.resourceDao = resourceDao;
    }


    @Override
    public Optional<Resource> getResourceById(Long id) {
        return Optional.ofNullable(resourceDao.findOne(id));
    }

    @Override
    public Collection<Resource> getAllResources() {
        return resourceDao.findAll();
    }

    @Override
    public Optional<Resource> getResourceByFuncId(String funcId) {
        return Optional.ofNullable(resourceDao.findOneByFuncId(funcId));
    }

    @Override
    public Resource save(Resource obj) {
        if(null != obj) {
            Optional<Resource> oo = Optional.ofNullable(resourceDao.findOneByFuncId(obj.getFuncId()));
            if (oo.isPresent()) {
                Resource resource = oo.get();
                BeanUtils.copyPropertiesIgnoreNull(obj, resource);
                return resourceDao.save(resource);
            }else{
                return resourceDao.save(obj);
            }
        }
        return null;
    }
    @Override
    public Resource create(Resource obj) {
        return save(obj);
    }

    @Override
    public Resource add(Resource obj) {
        return save(obj);
    }
}
