package cc.aisc.platform.eny.business.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by sjf on 15-11-12.
 */
@Service
@Transactional
public class DealServiceImpl implements DealService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DealServiceImpl.class);
}
