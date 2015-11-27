package cc.aisc.platform.eny.company.service;

import cc.aisc.platform.eny.company.dao.FactoryDao;
import cc.aisc.platform.eny.company.entity.Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * Created by sjf on 15-11-11.
 */
@Service
@Transactional
public class FactoryServiceImpl implements FactoryService {

    @Autowired
    private FactoryDao factoryDao;

    @Override
    public Factory add(Factory factory) {
        return factoryDao.save(factory);
    }

    @Override
    public void delete(Factory factory) {
        factoryDao.delete(factory);
    }

    @Override
    public Factory update(Factory factory) {
        return factoryDao.save(factory);
    }

    @Override
    public Optional<Page<Factory>> findAll(int page, int size) {
        return Optional.ofNullable(factoryDao.findAll(new PageRequest(page - 1, size)));
    }

    @Override
    public Optional<Factory> findByFactorySn(String farmSn) {
        return Optional.ofNullable(factoryDao.findByFactorySn(farmSn));
    }

    @Override
    public Optional<Page<Factory>> findByName(String name, int page, int size) {
        return Optional.ofNullable(factoryDao.findByName(name, new PageRequest(page - 1, size)));
    }
}
