package cc.aisc.platform.commons.auth.currentuser;

import cc.aisc.platform.commons.auth.role.RoleEnum;
import cc.aisc.platform.commons.auth.user.entity.User;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.Date;

/**
 * Created by sjf on 15-11-11.
 */
public class CurrentUser extends org.springframework.security.core.userdetails.User {

    private User user;

    public CurrentUser(User user) {
        super(user.getEmail(), user.getPasswordHash(), user.getEnabled(),
                user.getDateExpired().after(new Date()), true, user.getNonLocked(),
                AuthorityUtils.createAuthorityList(user.getRoleEnum().toString()));
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public Long getId() {
        return user.getId();
    }

    public RoleEnum getRole() {
        return user.getRoleEnum();
    }

    @Override
    public String toString() {
        return "CurrentUser{" +
                "user=" + user +
                "} " + super.toString();
    }
}
