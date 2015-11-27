package cc.aisc.platform.commons.base;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * Created by sjf on 15-11-27.
 */
/*@NoRepositoryBean*/
public class BaseDaoImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements BaseDao<T, ID> {
    private final EntityManager entityManager;

    public BaseDaoImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }

    public void delete(ID[] ids) {

    }

    public List<T> findAll() {
        return null;
    }

    public List<T> findAll(Sort sort) {
        return null;
    }

    public Page<T> findAll(Pageable pageable) {
        return null;
    }

}
