package cc.aisc.platform.eny.company.service;

import cc.aisc.platform.eny.company.entity.Factory;
import org.springframework.data.domain.Page;

import java.util.Optional;

/**
 * Created by sjf on 15-11-11.
 */
public interface FactoryService {
    Factory add(Factory factory);
    void delete(Factory factory);
    Factory update(Factory factory);
    Optional<Page<Factory>> findAll(int page,int size);
    Optional<Factory> findByFactorySn(String farmSn);
    Optional<Page<Factory>> findByName(String name, int page, int size);
}
