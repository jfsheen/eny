package cc.aisc.platform.eny.customer.dao;

import cc.aisc.platform.commons.base.BaseDao;
import cc.aisc.platform.eny.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sjf on 15-11-12.
 */
public interface CustomerDao extends JpaRepository<Customer, Long> {
}
