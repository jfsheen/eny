package cc.aisc.platform.auth.currentuser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Created by sjf on 15-11-11.
 */
@ControllerAdvice
public class CurrentUserControllerAdvice {

    private static final Logger LOGGER = LoggerFactory.getLogger(CurrentUserControllerAdvice.class);

    @ModelAttribute("currentUser")
    public CurrentUser getCurrentUser(Authentication authentication) {
        LOGGER.debug("Check WTF is the Authentication = {}",
                (authentication == null) ? null : (CurrentUser) authentication.getPrincipal());
        return (authentication == null) ? null : (CurrentUser) authentication.getPrincipal();
    }

}
