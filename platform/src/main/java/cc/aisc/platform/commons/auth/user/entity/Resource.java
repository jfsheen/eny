package cc.aisc.platform.commons.auth.user.entity;

import cc.aisc.platform.commons.base.BaseEntity;
import com.google.common.base.Objects;

import javax.persistence.*;

/**
 * Created by sjf on 15-12-1.
 */
@Entity
@Table(name = "t_auth_resource")
public class Resource extends BaseEntity<Long> {

    @Column(name = "res_name")
    private String name;

    @Column(name = "func_id")
    private String funcId;

    @Column(name = "can_access")
    private Boolean access;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Role role;

    @Column(name = "res_desc")
    private String description;

    @Override
    public String toString() {
        return "Resource{" +
                "name='" + name + '\'' +
                ", funcId='" + funcId + '\'' +
                ", access=" + access +
                ", role=" + role +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Resource resource = (Resource) o;
        return Objects.equal(name, resource.name) &&
                Objects.equal(funcId, resource.funcId) &&
                Objects.equal(access, resource.access) &&
                Objects.equal(role, resource.role) &&
                Objects.equal(description, resource.description);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), name, funcId, access, role, description);
    }

    public String getFuncId() {

        return funcId;
    }

    public void setFuncId(String funcId) {
        this.funcId = funcId;
    }

    public Boolean getAccess() {
        return access;
    }

    public void setAccess(Boolean access) {
        this.access = access;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
