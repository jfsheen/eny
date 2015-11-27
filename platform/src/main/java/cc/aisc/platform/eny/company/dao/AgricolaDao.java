package cc.aisc.platform.eny.company.dao;

import cc.aisc.platform.commons.base.BaseDao;
import cc.aisc.platform.eny.company.entity.Agricola;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


/**
 * Created by sjf on 15-11-11.
 */
public interface AgricolaDao extends JpaRepository<Agricola, Long> {
    Agricola findOneByAgricolaSn(String agricolaSn);
    @Query("select a from Agricola a where a.person.id in (select p.id from Person p where p.name = ?1)")
    Page<Agricola> findByPersonName(String personName, Pageable pageable);
}
