package cc.aisc.platform.commons.auth.controller;


import cc.aisc.platform.commons.base.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController/* extends BaseController*/{

    @RequestMapping("/")
    public String getHomePage() {
        //LOGGER.debug("Getting home page");
        return "home";
    }
}