package cc.aisc.platform.eny.company.dao;

import cc.aisc.platform.eny.company.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sjf on 15-11-27.
 */
public interface CompanyDao extends JpaRepository<Company, Long> {
}
