package cc.aisc.platform.eny.company.controller;

import cc.aisc.platform.eny.company.dto.FactoryCreateForm;
import cc.aisc.platform.eny.company.entity.Factory;
import cc.aisc.platform.eny.company.service.FactoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;
/**
 * Created by sjf on 15-11-26.
 */
@RestController
@RequestMapping("/factory")
public class FactoryController {
    private static final Logger LOGGER = LoggerFactory.getLogger(FactoryController.class);

    private final FactoryService factoryService;

    @Autowired
    public FactoryController(FactoryService factoryService) {
        this.factoryService = factoryService;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView factoryCreatePage(){
        LOGGER.debug("get factory create page!");
        return new ModelAndView("factory_create", "form", new FactoryCreateForm());
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView factoryCreate(@Valid FactoryCreateForm form, BindingResult bindingResult){
        LOGGER.debug("create factory.");
        if (bindingResult.hasErrors()) {
            // failed validation
           /* model.addAttribute("form", form);*/
            return new ModelAndView("factory_create", "form", form);
        }try {

        }
        catch (DataIntegrityViolationException e) {
            // probably email already exists - very rare case when multiple admins are adding same user
            // at the same time and dto validation has passed for more than one of them.
            LOGGER.warn("Exception occurred when trying to save the factory, assuming duplicate email", e);
            bindingResult.reject("email.exists", "Email already exists");
            return new ModelAndView("factory_create", "form", form);
        }
        // ok, redirect
        return new ModelAndView("redirect:/factory/list/1");
    }

    @RequestMapping(value = "/list/{page}")
    public ModelAndView listCategories(@PathVariable Integer page){
        Optional<Page<Factory>> rs = factoryService.findAll(page, 10);
        return new ModelAndView("factory_list", "_rs", rs.get().getContent());
    }
}
