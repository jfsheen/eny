package cc.aisc.platform.commons.auth.user.entity;

import cc.aisc.platform.commons.auth.user.entity.Group;
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
@Table(name = "t_auth_role")
public class Role extends BaseEntity<Long> {

    @Column(name = "role_name")
    private String name;

    @Column(name = "role_desc")
    private String description;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "grRole")
    private Set<GroupRole> groupRoles = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "role")
    private List<Resource> resourceList = new ArrayList<>();

    @Override
    public String toString() {
        return "Role{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", groupRoles=" + groupRoles +
                ", resourceList=" + resourceList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Role role = (Role) o;
        return Objects.equal(name, role.name) &&
                Objects.equal(description, role.description) &&
                Objects.equal(groupRoles, role.groupRoles) &&
                Objects.equal(resourceList, role.resourceList);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), name, description, groupRoles, resourceList);
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

    public Set<GroupRole> getGroupRoles() {
        return groupRoles;
    }

    public void setGroupRoles(Set<GroupRole> groupRoles) {
        this.groupRoles = groupRoles;
    }

    public List<Resource> getResourceList() {
        return resourceList;
    }

    public void setResourceList(List<Resource> resourceList) {
        this.resourceList = resourceList;
    }
}
