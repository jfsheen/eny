package cc.aisc.platform.commons.auth.currentuser;

import cc.aisc.platform.commons.auth.entity.Group;
import cc.aisc.platform.commons.auth.entity.Role;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by sjf on 16-1-22.
 */
public class CurrentUserAuth {

    private Set<Group> groups = new HashSet<>();
    private Set<Role> roles = new HashSet<>();

    public CurrentUserAuth(Set<Group> groups, Set<Role> roles) {
        this.groups = groups;
        this.roles = roles;
    }

    public List<String> listAuthorities(){
        List<String> authorities = new ArrayList<String>();
        for (Group group : groups){
            group.getRoles().stream().filter(role -> !authorities.contains(role.toAuthority())).forEach(role -> authorities.add(role.toAuthority()));
        }
        roles.stream().filter(role -> !authorities.contains(role.toAuthority())).forEach(role -> authorities.add(role.toAuthority()));
        return authorities;
    }

    public String [] getAuthoritiesArray() {
        List<String> authorities = listAuthorities();
        return authorities.toArray(new String[authorities.size()]);
    }
}
