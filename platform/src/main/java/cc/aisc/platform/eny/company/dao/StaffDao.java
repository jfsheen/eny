package cc.aisc.platform.eny.company.dao;

import cc.aisc.platform.eny.company.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sjf on 15-11-28.
 */
public interface StaffDao extends JpaRepository<Staff, Long> {
}
