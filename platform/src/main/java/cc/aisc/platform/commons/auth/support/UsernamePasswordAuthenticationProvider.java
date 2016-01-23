package cc.aisc.platform.commons.auth.support;

import cc.aisc.platform.constant.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.security.auth.login.AccountExpiredException;
import javax.security.auth.login.AccountLockedException;

/**
 * Created by sjf on 15-12-2.
 */
@Component
public class UsernamePasswordAuthenticationProvider implements AuthenticationProvider {

    private final UserDetailsService userDetailsService;

    @Autowired
    public UsernamePasswordAuthenticationProvider(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken)authentication;
        String username = token.getName();
        UserDetails userDetails = null;
        if( username.length() > 0 ){
            userDetails = userDetailsService.loadUserByUsername(username);
        }
        if(userDetails == null){
            throw new UsernameNotFoundException(Constant.AUTH_USERNAME_PASSWORD_INVALID);
        }else if(!userDetails.isEnabled()){
            throw new DisabledException(Constant.AUTH_ACCOUNT_DISABLED);
        }else if(!userDetails.isAccountNonExpired()){
            try {
                throw new AccountExpiredException(Constant.AUTH_ACCOUNT_EXPIRED);
            } catch (AccountExpiredException e) {
                e.printStackTrace();
            }
        }else if(!userDetails.isAccountNonLocked()){
            try {
                throw new AccountLockedException(Constant.AUTH_ACCOUNT_LOCKED);
            } catch (AccountLockedException e) {
                e.printStackTrace();
            }
        }else if(!userDetails.isCredentialsNonExpired()){
            throw new CredentialsExpiredException(Constant.AUTH_CRDDITAL_EXPIRED);
        }

        String password = userDetails.getPassword();
        if(!password.equals(token.getCredentials())){
            throw new BadCredentialsException(Constant.AUTH_USERNAME_PASSWORD_INVALID);
        }

        return new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return UsernamePasswordAuthenticationToken.class.equals(aClass);
    }
}
