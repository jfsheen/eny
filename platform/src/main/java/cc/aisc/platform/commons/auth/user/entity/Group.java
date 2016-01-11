package cc.aisc.platform.commons.auth.user.entity;

import cc.aisc.platform.commons.base.BaseEntity;
import com.google.common.base.Objects;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by sjf on 15-12-1.
 */
@Entity
@Table(name = "t_auth_group")
public class Group extends BaseEntity<Long> {

    @Column(name = "group_name")
    private String name;

    @Column(name = "group_desc")
    private String description;

    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_id")
    private Group parent;

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER, mappedBy = "parent")
    private List<Group> children = new ArrayList<>();

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER, mappedBy = "ugGroup")
    private Set<UserGroup> userGroups = new HashSet<>();

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER, mappedBy = "grGroup")
    private Set<GroupRole> groupRoles = new HashSet<>();

    @Override
    public String toString() {
        return "Group{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", parent=" + parent +
                ", children=" + children +
                ", userGroups=" + userGroups +
                ", groupRoles=" + groupRoles +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Group group = (Group) o;
        return Objects.equal(name, group.name) &&
                Objects.equal(description, group.description) &&
                Objects.equal(parent, group.parent) &&
                Objects.equal(children, group.children) &&
                Objects.equal(userGroups, group.userGroups) &&
                Objects.equal(groupRoles, group.groupRoles);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), name, description, parent, children, userGroups, groupRoles);
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Group getParent() {
        return parent;
    }

    public void setParent(Group parent) {
        this.parent = parent;
    }

    public List<Group> getChildren() {
        return children;
    }

    public void setChildren(List<Group> children) {
        this.children = children;
    }

    public Set<UserGroup> getUserGroups() {
        return userGroups;
    }

    public void setUserGroups(Set<UserGroup> userGroups) {
        this.userGroups = userGroups;
    }

    public Set<GroupRole> getGroupRoles() {
        return groupRoles;
    }

    public void setGroupRoles(Set<GroupRole> groupRoles) {
        this.groupRoles = groupRoles;
    }
}
