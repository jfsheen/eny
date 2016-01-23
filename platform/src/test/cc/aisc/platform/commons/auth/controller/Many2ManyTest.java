package cc.aisc.platform.commons.auth.controller;

import cc.aisc.platform.commons.auth.currentuser.CurrentUserAuth;
import cc.aisc.platform.commons.auth.dto.UserDto;
import cc.aisc.platform.commons.auth.entity.Group;
import cc.aisc.platform.commons.auth.entity.Resource;
import cc.aisc.platform.commons.auth.entity.Role;
import cc.aisc.platform.commons.auth.entity.User;
import cc.aisc.platform.commons.auth.service.GroupService;
import cc.aisc.platform.commons.auth.service.ResourceService;
import cc.aisc.platform.commons.auth.service.RoleService;
import cc.aisc.platform.commons.auth.service.UserService;
import cc.aisc.platform.eny.product.entity.Category;
import cc.aisc.platform.eny.product.service.CategoryService;
import cc.asic.platform.test.TestConfig;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by sjf on 16-1-14.
 */

@Rollback(false)
public class Many2ManyTest extends TestConfig{

    private final static Logger logger = LoggerFactory.getLogger(Many2ManyTest.class);
    @Autowired
    private ResourceService resourceService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserService userService;
    @Autowired
    private GroupService groupService;

    @Test
    public void insertResources() throws Exception {
        Resource resource = new Resource("root", "0000", "test res root");
        Resource resource1 = new Resource("res1", "0001", "test res 1");
        Resource resource2 = new Resource("res2", "0002", "test res 2");
        Resource resource3 = new Resource("res3", "0003", "test res 3");
        Resource resource4 = new Resource("res4", "0004", "test res 4");
        resource1.setLevel(resource.getLevel() + 1);
        resource1.setParent(resource);
        resource1.setSort(1);
        resource.getChildren().add(resource1);
        resource2.setLevel(resource.getLevel() + 1);
        resource2.setParent(resource);
        resource2.setSort(2);
        resource.getChildren().add(resource2);
        resource3.setLevel(resource1.getLevel() + 1);
        resource3.setParent(resource1);
        resource3.setSort(1);
        resource1.getChildren().add(resource3);
        resource4.setLevel(resource1.getLevel() + 1);
        resource4.setParent(resource1);
        resource1.getChildren().add(resource4);

        resourceService.save(resource);
    }

    @Test
    public void insertRoles() throws Exception {

        Role role1 = new Role();
        Role role2 = new Role();
        Role role3 = new Role();

        role1.setRoleName("CO1_USER");
        role1.setDescription("user for company 1");
        roleService.save(role1);
        role1.setRoleName("CO_ADMIN");
        role1.setDescription("admin for company 1");
        role1 = roleService.save(role1);
        User u1 = userService.getUserByUsername("demo").get();
        u1.getRoles().add(role1);
        userService.save(u1);

        role2.setRoleName("CO2_USER");
        role2.setDescription("user for company 2");
        roleService.save(role2);

        role3.setRoleName("CO3_USER");
        role3.setDescription("user for company 3");
        roleService.save(role3);

    }

    @Test
    public void insertUsersAndGroups() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String ymd = "2016-12-31";
        Date date = sdf.parse(ymd);
        User u1 = new User("demo", "demo", date, true, true);
        User u2 = new User("demo1", "demo", date, true, true);
        UserDto userDto = new UserDto();
        userDto.setUsername("demo2");
        userDto.setPassword("demo");
        userDto.setDateExpired(date);
        userDto.setNonLocked(true);
        userDto.setEnabled(true);
        userService.save(u1);
        userService.save(u2);
        userService.create(userDto);

        Group group1 = new Group();
        group1.setGroupName("group1");
        group1.setDescription("group 1 desc");
        group1.setLevel(1);
        Group group2 = new Group();
        group2.setGroupName("group2");
        group2.setDescription("group 2 desc");
        group2.setLevel(2);
        group1.getChildren().add(group2);
        group2.setParent(group1);
        groupService.save(group1);
    }

    @Test
    public void insertRelations() throws Exception {

        Optional<Group> g1 = groupService.getGroupByGroupName("group1");
        Optional<Group> g2 = groupService.getGroupByGroupName("group2");

        Optional<Role> r1 = roleService.getRoleByRoleName("CO1_USER");
        Optional<Role> r2 = roleService.getRoleByRoleName("CO2_USER");
        Optional<Role> r3 = roleService.getRoleByRoleName("CO3_USER");

        Optional<User> u11 = userService.getUserByUsername("demo");
        Optional<User> u22 = userService.getUserByUsername("demo1");




        u11.get().getGroups().add(g1.get());
        u11.get().getGroups().add(g2.get());
        u22.get().getGroups().add(g2.get());

        u11.get().getRoles().add(r3.get());

        userService.save(u11.get());
        userService.save(u22.get());

        /*groupService.save(g1.get());
        groupService.add(g2.get());

        userService.add(u11.get());
        userService.add(u22.get());*/

    }

    @Test
    public void getUserAuth() throws Exception{
        User user = userService.getUserByUsername("demo").get();
        CurrentUserAuth currentUserAuth = new CurrentUserAuth(user.getGroups(), user.getRoles());
        List<String> auth = currentUserAuth.listAuthorities();
        System.out.println(auth);
    }

    @Test
    public void userGroup() throws Exception {
        User user = userService.getUserByUsername("demo2").get();
        Group g1 = groupService.getGroupByGroupName("group1").get();
        Group g2 = groupService.getGroupByGroupName("group2").get();
        Set<Group> groupSet = new HashSet<>();
        groupSet.add(g1);
        groupSet.add(g2);
        userService.addGroups(user, groupSet);
    }

    @Test
    public void groupRole() throws Exception {

        Group g1 = groupService.getGroupByGroupName("group1").get();
        Group g2 = groupService.getGroupByGroupName("group2").get();

        Role r1 = roleService.getRoleByRoleName("CO1_USER").get();
        Role r2 = roleService.getRoleByRoleName("CO2_USER").get();
        Role r3 = roleService.getRoleByRoleName("CO3_USER").get();
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(r1);
        roleSet.add(r2);
        groupService.addRoles(g1, roleSet);

        roleSet.add(r3);

        groupService.addRoles(g2, roleSet);
    }

    @Test
    public void roleResource() throws Exception {

        Role r1 = roleService.getRoleByRoleName("CO1_USER").get();
        Role r2 = roleService.getRoleByRoleName("CO2_USER").get();
        Role r3 = roleService.getRoleByRoleName("CO3_USER").get();

        Optional<Resource> or0 = resourceService.getResourceByFuncId("0000");
        Optional<Resource> or3 = resourceService.getResourceByFuncId("0003");
        Optional<Resource> or2 = resourceService.getResourceByFuncId("0002");

        Set<Resource> resources = new HashSet<>();
        resources.add(or0.get());
        resources.add(or2.get());
        roleService.addResources(r1, resources);

        resources.add(or3.get());
        roleService.addResources(r2, resources);

        resources.remove(or2.get());
        roleService.addResources(r3, resources);

        /*Set<Role> roleSet = new HashSet<>();
        roleSet.add(r1);
        roleSet.add(r2);
        roleSet.add(r3);*/

    }

    @Test
    public void addmenu() throws Exception{

        Category menu = new Category();
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
        categoryService.save(menu);
    }
}