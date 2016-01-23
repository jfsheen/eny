package cc.aisc.platform.system.init;

import cc.aisc.platform.commons.auth.service.GroupService;
import cc.aisc.platform.commons.auth.service.ResourceService;
import cc.aisc.platform.commons.auth.service.RoleService;
import cc.aisc.platform.commons.auth.service.UserService;
import cc.aisc.platform.commons.base.Loggable;
import cc.aisc.platform.eny.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by sjf on 15-11-24.
 */
@Component
public class AppStartup extends Loggable implements ApplicationListener<ContextRefreshedEvent>{


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

    }
}
