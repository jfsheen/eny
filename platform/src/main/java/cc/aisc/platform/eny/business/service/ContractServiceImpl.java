package cc.aisc.platform.eny.business.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by sjf on 15-11-18.
 */
@Service
@Transactional
public class ContractServiceImpl implements ContractService {
    private final static Logger LOGGER = LoggerFactory.getLogger(ContractServiceImpl.class);
}
