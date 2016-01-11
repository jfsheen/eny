package cc.aisc.platform.commons.info;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

/**
 * Created by sjf on 15-11-14.
 */
public interface PersonDao extends JpaRepository<Person, Long> {
    Collection<Person> findByName(String name);
}
