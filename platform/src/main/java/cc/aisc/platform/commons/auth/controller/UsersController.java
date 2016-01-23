package cc.aisc.platform.commons.auth.controller;

import cc.aisc.platform.commons.auth.service.UserService;
import cc.aisc.platform.commons.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsersController/* extends BaseController */{

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/users")
    public ModelAndView getUsersPage() {
        //LOGGER.debug("Getting users page");
        return new ModelAndView("users", "_rs", userService.getAllUsers());
    }


}