package cc.aisc.platform.eny.company.dao;

import cc.aisc.platform.commons.base.BaseDao;
import cc.aisc.platform.eny.company.entity.Factory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sjf on 15-11-11.
 */
public interface FactoryDao extends JpaRepository<Factory, Long> {
    Factory findByFactorySn(String factroySn);
    Page<Factory> findByName(String name, Pageable pageable);
}
