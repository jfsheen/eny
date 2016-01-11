package cc.aisc.platform.eny.company.dao;

import cc.aisc.platform.eny.company.entity.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sjf on 15-11-11.
 */
public interface DepartmentDao extends JpaRepository<Department, Long> {
    Department findByDepartmentSn(String factroySn);
    Page<Department> findByName(String name, Pageable pageable);
}
