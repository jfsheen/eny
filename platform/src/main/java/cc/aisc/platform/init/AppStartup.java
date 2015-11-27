package cc.aisc.platform.init;

import cc.aisc.platform.auth.role.Role;
import cc.aisc.platform.auth.user.entity.User;
import cc.aisc.platform.auth.user.service.UserService;
import cc.aisc.platform.commons.Constant;
import cc.aisc.platform.utils.JsonUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by sjf on 15-11-24.
 */
@Component
public class AppStartup implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppStartup.class);

    /*@Autowired
    private CategoryService categoryService;*/

    @Autowired
    private UserService userService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        LOGGER.debug("Init APP context now!");
        User user = new User("demo@localhost","demo",Role.ADMIN);
        user = userService.save(user);

        /* category test */
        JSONArray jsonArray = new JSONArray();
        /*Category menu = new Category();
        menu.setName("root menu");
        menu.setLevel(0);
        menu.setDescription("root menu levle=0");
        Category menu1 = new Category(menu);
        menu1.setName("menu1");
        menu1.setDescription("menu1 level=0 parent=null");
        menu.getChildren().add(menu1);
        Category menu2 = new Category(menu);
        menu2.setName("menu2");
        menu2.setDescription("menu2 level=0 parent=null");
        menu.getChildren().add(menu2);
        Category menu3 = new Category(menu2);
        menu3.setName("menu3");
        menu3.setDescription("menu3 level=1 parent=menu2");
        menu2.getChildren().add(menu3);
        Category menu4 = new Category(menu2);
        menu4.setName("menu4");
        menu4.setDescription("menu4 level=1 parent=menu2");
        menu2.getChildren().add(menu4);
        Category menu5 = new Category(menu4);
        menu5.setName("menu5");
        menu5.setDescription("menu5 level=2 parent=menu4");
        menu4.getChildren().add(menu5);
        Category menu6 = new Category(menu1);
        menu6.setName("menu6");
        menu6.setDescription("menu6 level=1 parent=menu1");
        menu1.getChildren().add(menu6);
        categoryService.add(menu);*/

        /*Category rc = categoryService.findCategoryById(1l).get();

        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
        jsonConfig.setExcludes(Constant.JSONCONFIG_EXCLUDES);
        JSONArray ja = JSONArray.fromObject(rc, jsonConfig);

        LOGGER.debug("json = {}", ja);*/
        LOGGER.debug("Init USER = {}", user);
    }
}
