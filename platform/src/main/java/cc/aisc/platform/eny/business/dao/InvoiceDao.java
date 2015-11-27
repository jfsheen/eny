package cc.aisc.platform.eny.business.dao;

import cc.aisc.platform.commons.base.BaseDao;
import cc.aisc.platform.eny.business.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sjf on 15-11-18.
 */
public interface InvoiceDao extends JpaRepository<Invoice, Long> {
}
