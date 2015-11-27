package cc.aisc.platform.commons.entity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

/**
 * Created by sjf on 15-11-14.
 */
public interface ContactDao extends JpaRepository<Contact, Long> {
    Contact findByContact(String contact);
    Collection<Contact> findByContactType(ContactType contactType);
    Contact findByContactTypeAndContact(ContactType contactType, String contact);
}
