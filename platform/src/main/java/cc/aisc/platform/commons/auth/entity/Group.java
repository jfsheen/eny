package cc.aisc.platform.commons.auth.entity;

import cc.aisc.platform.commons.base.BaseTreeEntity;
import com.google.common.base.Objects;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sjf on 15-12-1.
 */
@Entity
@Table(name = "t_auth_group")
public class Group extends BaseTreeEntity<Long, Group> {

    @Column(name = "group_name", nullable = false, unique = true)
    private String groupName;

    @Column(name = "group_desc")
    private String description;

    /*@ManyToMany(cascade=CascadeType.REFRESH,mappedBy="groups", fetch = FetchType.LAZY)
    private Set<User> users = new HashSet<User>();*/

    @ManyToMany(cascade=CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinTable(name="auth_group_role",
            inverseJoinColumns=@JoinColumn(name="role_id"),
            joinColumns=@JoinColumn(name="group_id"))
    private Set<Role> roles = new HashSet<Role>();

    public Group(String groupName, String description) {
        this.groupName = groupName;
        this.description = description;
    }
    public Group(Group parent) {
        super(parent.getLevel(), parent);
    }

    public Group() {
    }

    public void addRole(Role role){
        this.roles.add(role);
    }
    public void removeRole(Role role){
        this.roles.remove(role);
    }

/*    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }*/

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getGroupName() {

        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupName='" + groupName + '\'' +
                ", description='" + description + '\'' +
                //", users=" + users +
                ", roles=" + roles +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Group group = (Group) o;
        return Objects.equal(groupName, group.groupName) &&
                Objects.equal(description, group.description) &&
                //Objects.equal(users, group.users) &&
                Objects.equal(roles, group.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), groupName, description/*, users*/, roles);
    }
}
