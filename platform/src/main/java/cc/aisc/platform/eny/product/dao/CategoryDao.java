package cc.aisc.platform.eny.product.dao;

import cc.aisc.platform.commons.base.BaseDao;
import cc.aisc.platform.eny.product.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

/**
 * Created by sjf on 15-11-11.
 */
public interface CategoryDao extends JpaRepository<Category, Long> {
    Category findOneByCategorySn(String categorySn);
    Page<Category> findByName(String name, Pageable pageable);
    Collection<Category> findByName(String name);
    Collection<Category> findByLevelLessThan(Integer lvlLt);

/*    @Query("UPDATE Category c SET c.category = ?1 WHERE c.id = ?2")
    void updatePid0(Long pid, Long cid);*/
}
