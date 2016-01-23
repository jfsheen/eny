package cc.aisc.platform.eny.customer.service;

import cc.aisc.platform.commons.base.BaseService;
import cc.aisc.platform.eny.customer.dao.CustomerDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by sjf on 15-11-12.
 */
@Service
@Transactional
public class CustomerServiceImpl extends BaseService implements CustomerService {

    @Autowired
    private CustomerDao customerDao;
}
