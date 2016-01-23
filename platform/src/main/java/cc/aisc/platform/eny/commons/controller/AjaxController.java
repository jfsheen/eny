package cc.aisc.platform.eny.commons.controller;

import cc.aisc.platform.commons.base.BaseController;
import cc.aisc.platform.constant.Constant;
import cc.aisc.platform.eny.commons.dto.ImageAddDto;
import cc.aisc.platform.eny.commons.dto.TraitAddDto;
import cc.aisc.platform.eny.commons.service.ImageService;
import cc.aisc.platform.eny.commons.service.TraitService;
import cc.aisc.platform.eny.product.service.CategoryService;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created by sjf on 15-11-19.
 */
@RestController
public class AjaxController extends BaseController {

    private final TraitService traitService;
    private final ImageService imageService;
    private final CategoryService categoryService;

    @Autowired
    public AjaxController(TraitService traitService, ImageService imageService, CategoryService categoryService) {
        this.traitService = traitService;
        this.imageService = imageService;
        this.categoryService = categoryService;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/trait/add", method = { RequestMethod.GET})
    public ModelAndView addTrait(){
        LOGGER.debug("Processing ADD PRODUCT TRAIT page.");
        return new ModelAndView("add_trait", "dto", new TraitAddDto());
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/ajax/trait/add", method = {RequestMethod.POST}, produces = "application/json")
    public TraitAddDto addProductTrait(@Valid @RequestBody TraitAddDto dto, BindingResult bindingResult){
        LOGGER.debug("Processing ADD PRODUCT TRAIT data = {}, bindingResult = {}", dto, bindingResult);
        if (bindingResult.hasErrors()) {
            return dto;
        }
        return dto;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/ajax/image/add", method = RequestMethod.POST)
    public ModelAndView addImage(@Valid @RequestBody ImageAddDto dto, BindingResult bindingResult){
        LOGGER.debug("Processing ADD IMAGE dto = {}, bindingResult = {}", dto, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ModelAndView("add_image", "dto", dto);
        }
        return new ModelAndView("add_image", "dto", dto);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/ajax/category", method = RequestMethod.POST)
    public String listCategoryById(@RequestBody String id) throws Exception {
        LOGGER.debug("Processing ADD category id = {}", id);
        Long ids = Long.parseLong(id);
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
        jsonConfig.setExcludes(Constant.JSONCONFIG_EXCLUDES);
        JSONArray ja = JSONArray.fromObject(categoryService.findCategoryById(ids).get(), jsonConfig);
        LOGGER.debug("ja = {}", ja);
        return ja.toString();
    }

}
