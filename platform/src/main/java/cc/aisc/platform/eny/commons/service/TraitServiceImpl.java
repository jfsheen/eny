package cc.aisc.platform.eny.commons.service;

import cc.aisc.platform.eny.commons.dao.TraitDao;
import cc.aisc.platform.eny.commons.entity.Trait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * Created by sjf on 15-11-18.
 */
@Service
@Transactional
public class TraitServiceImpl implements TraitService {

    private final static Logger LOGGER = LoggerFactory.getLogger(TraitServiceImpl.class);

    private final TraitDao traitDao;

    @Autowired
    public TraitServiceImpl(TraitDao traitDao) {
        this.traitDao = traitDao;
    }

    @Override
    public Trait add(Trait trait) {
        return traitDao.save(trait);
    }

    @Override
    public void delete(Trait trait) {
        traitDao.delete(trait);
    }

    @Override
    public Optional<Trait> findById(Long id) {
        return Optional.ofNullable(traitDao.findOne(id));
    }
}
