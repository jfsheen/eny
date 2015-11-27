package cc.aisc.platform.eny.product.controller;

import cc.aisc.platform.eny.product.dto.CategoryCreateForm;
import cc.aisc.platform.eny.product.entity.Category;
import cc.aisc.platform.eny.product.service.CategoryService;
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
 * Created by sjf on 15-11-19.
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView categoryCreatePage(){
        LOGGER.debug("get categroy create page.");
        return  new ModelAndView("category_create", "form", new CategoryCreateForm());
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView categoryCreate(@Valid CategoryCreateForm form, BindingResult bindingResult){
        LOGGER.debug("create categroy.");
        if (bindingResult.hasErrors()) {
            // failed validation
           /* model.addAttribute("form", form);*/
            return new ModelAndView("category_create", "form", form);
        }try {
            Optional<Category> oc = categoryService.findCategoryById(form.getParentId());
            if (oc.isPresent()) {
                Category c = oc.get();
                Category category = new Category(c);
                c.getChildren().add(category);
                category.setDescription(form.getDescription());
                category.setName(form.getName());
                categoryService.add(category);
            }
        } catch (DataIntegrityViolationException e) {
            // probably email already exists - very rare case when multiple admins are adding same user
            // at the same time and dto validation has passed for more than one of them.
            LOGGER.warn("Exception occurred when trying to save the user, assuming duplicate email", e);
            bindingResult.reject("email.exists", "Email already exists");
            return new ModelAndView("category_create", "form", form);
        }
        // ok, redirect
        return new ModelAndView("redirect:/category/list/1");
    }

    @RequestMapping(value = "/list/{page}")
    public ModelAndView listCategories(@PathVariable Integer page){
        Optional<Page<Category>> categories = categoryService.findAll(page, 10);
        return new ModelAndView("category_list", "_rs", categories.get().getContent());
    }

}
