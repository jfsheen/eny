package cc.aisc.platform.commons.auth.service;

import cc.aisc.platform.commons.auth.entity.Resource;
import cc.aisc.platform.commons.base.BaseService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by sjf on 15-12-1.
 */
public interface ResourceService{

    Optional<Resource> getResourceById(Long id);

    Collection<Resource> getAllResources();

    Optional<Resource> getResourceByFuncId(String funcId);

    Resource create(Resource obj);

    Resource save(Resource obj);

    Resource add(Resource obj);
}
