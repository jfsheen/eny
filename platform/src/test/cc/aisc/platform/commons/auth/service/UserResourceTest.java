package cc.aisc.platform.commons.auth.service;

import cc.aisc.platform.commons.auth.RoleEnum;
import cc.aisc.platform.commons.auth.entity.User;
import cc.asic.platform.test.TestConfig;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.*;

/**
 * Created by sjf on 16-1-14.
 */
public class UserResourceTest extends TestConfig {

    @Autowired
    private ResourceService resourceService;
    @Autowired
    private UserService userService;

    @Test
    public void userResTest1() {
        /*Optional<Resource> resource = resourceService.getResourceByFuncId("0000");
        Optional<User> user = userService.getUserByUsername("demo");
        List resList = new ArrayList<Resource>();
        Set<Group> groupsSet =  user.get().getGroups();
        for (Group group : groupsSet) {
            Set<Role> roleSet = group.getRoles();
            for (Role role : roleSet){
                Set<Resource> resSet = role.getResources();
                for (Resource res : resSet){
                    resList.add(res.getFuncId());
                }
            }
        }*/
    }

    @Test
    public void testSave() throws Exception {
        Date date = DateUtils.addYears(new Date(), 1);
        User u1 = new User("demo", "demo", date, true, true);
        User u2 = new User("demo2", "demo", date, true, true);
        userService.save(u1);
        userService.save(u2);


    }




}