package cc.aisc.platform.eny.company.service;

import cc.aisc.platform.commons.entity.PersonDao;
import cc.aisc.platform.eny.company.dao.AgricolaDao;
import cc.aisc.platform.eny.company.entity.Agricola;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class AgricolaServiceImpl implements AgricolaService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AgricolaServiceImpl.class);

    private final AgricolaDao agricolaDao;

    @Autowired
    public AgricolaServiceImpl(AgricolaDao agricolaDao, PersonDao personDao) {
        this.agricolaDao = agricolaDao;
    }

    @Override
    public Agricola add(Agricola agricola) {
        return agricolaDao.save(agricola);
    }

    @Override
    public void delete(Agricola agricola) {
        agricolaDao.delete(agricola);
    }

    @Override
    public void delete(Long id) {
        agricolaDao.delete(id);
    }

    @Override
    public Agricola update(Agricola revised) {
        return agricolaDao.save(revised);
    }

    @Override
    public Optional<Page<Agricola>> findAll(int page, int size) {
        return Optional.ofNullable(agricolaDao.findAll(new PageRequest(page - 1, size)));
    }

    @Override
    public Optional<Agricola> getById(Long id) {
        return Optional.ofNullable(agricolaDao.findOne(id));
    }

    @Override
    public Optional<Agricola> getBySn(String sn) {
        return Optional.ofNullable(agricolaDao.findOneByAgricolaSn(sn));
    }

    @Override
    public Optional<Page<Agricola>> findByName(String name, int page, int size) {
        return Optional.ofNullable(agricolaDao.findByPersonName(name, new PageRequest(page - 1, size)));
    }
}
