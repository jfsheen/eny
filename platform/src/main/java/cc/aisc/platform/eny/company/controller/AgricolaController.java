package cc.aisc.platform.eny.company.controller;

import cc.aisc.platform.commons.base.BaseController;
import cc.aisc.platform.commons.info.Contact;
import cc.aisc.platform.commons.info.ContactService;
import cc.aisc.platform.commons.info.ContactType;
import cc.aisc.platform.commons.info.Person;
import cc.aisc.platform.eny.company.dto.AgricolaCreateForm;
import cc.aisc.platform.eny.company.entity.Agricola;
import cc.aisc.platform.eny.company.service.AgricolaService;
import cc.aisc.platform.eny.product.validator.AgricolaCreateFormValidator;
import cc.aisc.platform.utils.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * Created by sjf on 15-11-14.
 */
@Controller
@RequestMapping("/agricola")
public class AgricolaController extends BaseController{

    private final AgricolaService agricolaService;
    private final ContactService contactService;

    @Autowired
    public AgricolaController(AgricolaService agricolaService, AgricolaCreateFormValidator agrCreateFormValidator, ContactService contactService) {
        this.agricolaService = agricolaService;
        this.contactService = contactService;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView getAgricolaCreatePage() {
        LOGGER.debug("Getting agricola create form");
        return new ModelAndView("agricola_create", "form", new AgricolaCreateForm());
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView addAgricola(@Valid /*@ModelAttribute("form")*/ AgricolaCreateForm form, BindingResult bindingResult/*, ModelMap model*/){
        LOGGER.debug("Processing Agricola create form ={}, bindingResult = {}", form, bindingResult);
         //todo
        if (bindingResult.hasErrors()) {
            // failed validation
           /* model.addAttribute("form", form);*/
            return new ModelAndView("agricola_create", "form", form);
        }
        try {
            Agricola agricola = new Agricola();
            Person person = new Person();
            person.setName(form.getName());
            person.setGender(form.getGender());
            contactService.add(new Contact(ContactType.MOBILEPHONE, form.getCellphone(), "MOBILEPHONE", person));
            contactService.add(new Contact(ContactType.EMAIL, form.getEmail(), "EMAIL", person));
            contactService.add(new Contact(ContactType.QQ, form.getQq(), "QQ", person));
            agricola.setPerson(person);
            agricolaService.add(agricola);
        } catch (DataIntegrityViolationException e) {
            // probably email already exists - very rare case when multiple admins are adding same user
            // at the same time and dto validation has passed for more than one of them.
            LOGGER.warn("Exception occurred when trying to save the user, assuming duplicate email", e);
            bindingResult.reject("email.exists", "Email already exists");
            return new ModelAndView("agricola_create", "form", form);
        }
        // ok, redirect
        return new ModelAndView("redirect:/agricola/list/1");
    }

    @RequestMapping("/id/{id}")
    public Agricola getId(@PathVariable("id") String id){
        LOGGER.debug("get agricola id = {}.", id);
        Agricola agricola = agricolaService.getById(Long.parseLong(id)).get();
        agricola.setAgricolaSn(RandomUtils.getUuid(false));
        return agricolaService.update(agricola);
    }

    @RequestMapping("/name/{name}")
    public List<Agricola> getName(@PathVariable("name") String name){
        LOGGER.debug("get agricola name = {}.", name);
        return agricolaService.findByName(name, 1, 5).get().getContent();
    }

    @RequestMapping ("/list/{page}")
    public ModelAndView list(@PathVariable Integer page){
        LOGGER.debug("list Agricola page = {}", page);
        Optional<Page<Agricola>> agricolas = agricolaService.findAll(page, 10);
        return new ModelAndView("agricola_list", "_rs", agricolas.get().getContent());
    }

    @RequestMapping("/delete/id/{id}")
    public void delAgricola(@PathVariable String id){
        LOGGER.debug("del agricola id = {}", id);
        agricolaService.delete(Long.parseLong(id));

    }
}
