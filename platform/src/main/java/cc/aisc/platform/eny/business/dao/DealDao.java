package cc.aisc.platform.eny.business.dao;

import cc.aisc.platform.commons.base.BaseDao;
import cc.aisc.platform.eny.business.entity.Deal;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sjf on 15-11-12.
 */
public interface DealDao extends JpaRepository<Deal, Long> {
}
