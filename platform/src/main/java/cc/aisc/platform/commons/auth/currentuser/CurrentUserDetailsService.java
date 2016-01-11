package cc.aisc.platform.commons.auth.currentuser;

import cc.aisc.platform.commons.auth.user.entity.User;
import cc.aisc.platform.commons.auth.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by sjf on 15-11-11.
 */
@Service("userDetailsService")
public class CurrentUserDetailsService implements UserDetailsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CurrentUserDetailsService.class);
    private final UserService userService;

    @Autowired
    public CurrentUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public CurrentUser loadUserByUsername(String s) throws UsernameNotFoundException {
        LOGGER.debug("Authenticating user with username={}", s.replaceFirst("@.*", "@***"));
        User user = userService.getUserByUsername(s).orElseThrow(() -> new UsernameNotFoundException(String.format("User with USERNAME=%s was not found", s)));
        return new CurrentUser(user);
    }

}
