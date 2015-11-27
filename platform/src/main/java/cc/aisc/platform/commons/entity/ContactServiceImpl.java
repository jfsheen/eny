package cc.aisc.platform.commons.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * Created by sjf on 15-11-14.
 */
@Service
@Transactional
public class ContactServiceImpl implements ContactService {

    private final static Logger LOGGER = LoggerFactory.getLogger(ContactServiceImpl.class);

    private final ContactDao contactDao;

    @Autowired
    public ContactServiceImpl(ContactDao contactDao) {
        this.contactDao = contactDao;
    }

    @Override
    public Optional<Contact> findById(Long id) {
        LOGGER.debug("find contact by id = {}", id);
        return Optional.ofNullable(contactDao.findOne(id));
    }

    @Override
    public Contact add(Contact c) {
        LOGGER.debug("add contact = {}", c);
        return contactDao.save(c);
    }
}
