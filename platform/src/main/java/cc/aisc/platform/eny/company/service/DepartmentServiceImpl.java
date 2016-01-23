package cc.aisc.platform.eny.company.service;

import cc.aisc.platform.commons.base.BaseService;
import cc.aisc.platform.eny.company.dao.DepartmentDao;
import cc.aisc.platform.eny.company.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * Created by sjf on 15-11-11.
 */
@Service
@Transactional
public class DepartmentServiceImpl extends BaseService implements DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    @Override
    public Department add(Department department) {
        return departmentDao.save(department);
    }

    @Override
    public void delete(Department department) {
        departmentDao.delete(department);
    }

    @Override
    public Department update(Department department) {
        return departmentDao.save(department);
    }

    @Override
    public Optional<Page<Department>> findAll(int page, int size) {
        return Optional.ofNullable(departmentDao.findAll(new PageRequest(page - 1, size)));
    }

    @Override
    public Optional<Department> findByDepartmentSn(String sn) {
        return Optional.ofNullable(departmentDao.findByDepartmentSn(sn));
    }

    @Override
    public Optional<Page<Department>> findByName(String name, int page, int size) {
        return Optional.ofNullable(departmentDao.findByName(name, new PageRequest(page - 1, size)));
    }
}
