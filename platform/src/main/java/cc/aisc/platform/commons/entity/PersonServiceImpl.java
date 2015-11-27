package cc.aisc.platform.commons.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.Set;

/**
 * Created by sjf on 15-11-14.
 */
@Service
@Transactional
public class PersonServiceImpl implements PersonService {

    private final PersonDao personDao;

    @Autowired
    public PersonServiceImpl(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Override
    public Optional<Person> findById(Long id) {
        return Optional.ofNullable(personDao.findOne(id));
    }

}
