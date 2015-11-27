package cc.aisc.platform.commons.entity;


import java.util.Optional;
import java.util.Set;

/**
 * Created by sjf on 15-11-14.
 */
public interface PersonService {
    Optional<Person> findById(Long id);
}
