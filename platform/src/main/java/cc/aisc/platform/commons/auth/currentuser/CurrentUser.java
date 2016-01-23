package cc.aisc.platform.commons.auth.currentuser;

import cc.aisc.platform.commons.auth.entity.User;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.Date;

/**
 * Created by sjf on 15-11-11.
 */
public class CurrentUser extends org.springframework.security.core.userdetails.User {

    private User user;

    public CurrentUser(User user) {
        super(user.getUsername(), user.getPassword1(), user.getEnabled(),
                user.getDateExpired().after(new Date()), true, user.getNonLocked(),
                AuthorityUtils.createAuthorityList(new CurrentUserAuth(user.getGroups(), user.getRoles()).getAuthoritiesArray()));
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public Long getId() {
        return user.getId();
    }

    public Boolean hasAuthority(String auth){
        return new CurrentUserAuth(user.getGroups(), user.getRoles()).listAuthorities().contains(auth);
    }

    @Override
    public String toString() {
        return "CurrentUser{" +
                "user=" + user +
                "} " + super.toString();
    }
}
