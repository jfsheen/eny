package cc.aisc.platform.commons.info;


import java.util.Optional;

/**
 * Created by sjf on 15-11-14.
 */
public interface PersonService {
    Optional<Person> findById(Long id);
}
