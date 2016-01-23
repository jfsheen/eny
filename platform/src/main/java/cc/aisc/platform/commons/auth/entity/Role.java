package cc.aisc.platform.commons.auth.entity;

import cc.aisc.platform.commons.base.BaseEntity;
import com.google.common.base.Objects;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.util.Assert;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sjf on 15-12-1.
 */
@Entity
@Table(name = "t_auth_role")
public class Role extends BaseEntity<Long> {

    @Column(name = "role_name", nullable = false, unique = true)
    private String roleName;

    @Column(name = "role_desc")
    private String description;

    /**
     * JoinTable表示中间表
     * inverseJoinColumns表示关系被维护端对应的中间表的外键名
     * joinColumns表示关系维护端对应的中间表的外键名
     * @return
     */
    @ManyToMany(cascade={CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinTable(name="auth_role_resource",
            inverseJoinColumns=@JoinColumn(name="resource_id"),
            joinColumns=@JoinColumn(name="role_id"))
    private Set<Resource> resources = new HashSet<Resource>();

    public Role(String roleName, String description) {
        this.roleName = roleName;
        this.description = description;
    }

    public Role() {
    }

    public Set<Resource> getResources() {
        return resources;
    }

    public void setResources(Set<Resource> resources) {
        this.resources = resources;
    }

    public String getRoleName() {

        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /*public void addResource(Resource resource){
        this.resources.add(resource);
    }
    public void removeResource(Resource resource){
        this.resources.remove(resource);
    }*/

    public String toAuthority(){
        return this.roleName;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleName='" + roleName + '\'' +
                ", description='" + description + '\'' +
                ", resources=" + resources +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Role role = (Role) o;
        return Objects.equal(roleName, role.roleName) &&
                Objects.equal(description, role.description) &&
                Objects.equal(resources, role.resources);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), roleName, description, resources);
    }
}
