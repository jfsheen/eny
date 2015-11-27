package cc.aisc.platform.commons.entity;

import java.util.Optional;

/**
 * Created by sjf on 15-11-14.
 */
public interface ContactService {
    Optional<Contact> findById(Long id);
    Contact add(Contact c);

}
