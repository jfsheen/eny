package cc.aisc.platform.auth.currentuser;

import cc.aisc.platform.auth.role.Role;
import cc.aisc.platform.auth.user.entity.User;
import org.springframework.security.core.authority.AuthorityUtils;

/**
 * Created by sjf on 15-11-11.
 */
public class CurrentUser extends org.springframework.security.core.userdetails.User {

    private User user;

    public CurrentUser(User user) {
        super(user.getEmail(), user.getPasswordHash(), AuthorityUtils.createAuthorityList(user.getRole().toString()));
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public Long getId() {
        return user.getId();
    }

    public Role getRole() {
        return user.getRole();
    }

    @Override
    public String toString() {
        return "CurrentUser{" +
                "user=" + user +
                "} " + super.toString();
    }
}
