package cc.aisc.platform.eny.company.service;

import cc.aisc.platform.eny.company.entity.Department;
import org.springframework.data.domain.Page;

import java.util.Optional;

/**
 * Created by sjf on 15-11-11.
 */
public interface DepartmentService {
    Department add(Department department);
    void delete(Department department);
    Department update(Department department);
    Optional<Page<Department>> findAll(int page,int size);
    Optional<Department> findByDepartmentSn(String sn);
    Optional<Page<Department>> findByName(String name, int page, int size);
}
