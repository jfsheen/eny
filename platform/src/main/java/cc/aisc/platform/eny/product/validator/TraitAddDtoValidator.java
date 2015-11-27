package cc.aisc.platform.eny.product.validator;

import cc.aisc.platform.eny.commons.dto.TraitAddDto;
import cc.aisc.platform.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by sjf on 15-11-19.
 */
@Component
public class TraitAddDtoValidator implements Validator {
    private final static Logger LOGGER = LoggerFactory.getLogger(TraitAddDtoValidator.class);

    public boolean supports(Class<?> aClass) {
        return aClass.equals(TraitAddDto.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        LOGGER.debug("validating object = {}", o);
        TraitAddDto dto = (TraitAddDto)o;
        traitValidator(errors, dto);
        belong2idValidator(errors, dto);
        belong2Validator(errors, dto);
        imagesValidator(errors, dto);
    }

    private void traitValidator(Errors errors, TraitAddDto dto){
        LOGGER.debug("traitDto.trait = {}", dto.getTrait());
    }

    private void belong2Validator(Errors errors, TraitAddDto dto){
        LOGGER.debug("traitDto.belong2 = {}", dto.getBelong2());

    }

    private void belong2idValidator(Errors errors, TraitAddDto dto){
        LOGGER.debug("traitDto.belong2id = {}", dto.getBelong2id());
        if (!dto.getBelong2id().matches(StringUtils.regExp_integer_1)){
            errors.reject("ID_should_be_integer.", "belong2id should be integer.");
        }
    }

    private void imagesValidator(Errors errors, TraitAddDto dto){
        LOGGER.debug("traitDto.images = {}", dto.getImages());
    }
}
