package cc.aisc.platform.eny.product.validator;

import cc.aisc.platform.eny.company.dto.AgricolaCreateForm;
import cc.aisc.platform.eny.company.service.AgricolaService;
import cc.aisc.platform.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by sjf on 15-11-17.
 */
@Component
public class AgricolaCreateFormValidator implements Validator {
    private static final Logger LOGGER = LoggerFactory.getLogger(AgricolaCreateFormValidator.class);

    private final AgricolaService agricolaService;

    @Autowired
    public AgricolaCreateFormValidator(AgricolaService agricolaService) {
        this.agricolaService = agricolaService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(AgricolaCreateForm.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        LOGGER.debug("validating object = {}", o);
        AgricolaCreateForm form = (AgricolaCreateForm) o;
        validatePasswords(errors, form);
        validateName(errors, form);
        validateEmail(errors, form);
        validateCellphone(errors, form);
        validateQq(errors,form);
    }

    private void validateQq(Errors errors, AgricolaCreateForm form) {
        LOGGER.debug("form.Qq = {}", form.getQq());
        if(!form.getQq().matches(StringUtils.regExp_qq)){
            errors.reject("qq_not_match", "qq error.");
        }
    }

    private void validateCellphone(Errors errors, AgricolaCreateForm form) {
        LOGGER.debug("form.Cellphone = {}", form.getCellphone());
        if(!form.getCellphone().isEmpty()) {
            if (!form.getCellphone().matches(StringUtils.regExp_mobilephone)) {
                errors.reject("cellphone_error", "cellphone error!");
            }
        }else{
            errors.reject("cellphone_empty", "cellphone cannot be empty");
        }

    }

    private void validateEmail(Errors errors, AgricolaCreateForm form) {
        LOGGER.debug("form.Email = {}", form.getEmail());
        if (!form.getEmail().isEmpty()) {
            if (!form.getEmail().matches(StringUtils.regExp_email) || !form.getEmail().matches(StringUtils.regExp_qqmail)) {
                errors.reject("email_illegal", "email illegal");
            }
        }else {
            errors.reject("email_empty", "email cannot be empty");
        }
    }

    private void validateName(Errors errors, AgricolaCreateForm form) {
        LOGGER.debug("form.Name = {}", form.getName());
        if(!form.getName().isEmpty()) {
            if (form.getName().length() > 20 || form.getName().length() < 4) {
                errors.reject("name_length_error", "Too much char in Name.");
            }
        }else{
            errors.reject("name_empty", "Name cannot be empty");
        }
    }

    private void validatePasswords(Errors errors, AgricolaCreateForm form) {
        LOGGER.debug("form.Password = {},  form.PasswordRepeat = {}", form.getPassword(), form.getPasswordRepeat());
        if (!form.getPassword().isEmpty()) {
            if (!form.getPassword().equals(form.getPasswordRepeat())) {
                errors.reject("password.no_match", "Passwords do not match");
            }
        }else {

                errors.reject("password_empty", "Password cannot be empty");
        }
    }
}
