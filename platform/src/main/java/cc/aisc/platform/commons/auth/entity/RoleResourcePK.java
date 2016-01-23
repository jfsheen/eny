package cc.aisc.platform.commons.auth.entity;

import com.google.common.base.Objects;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by sjf on 16-1-11.
 */
@Embeddable
public class RoleResourcePK implements Serializable{

    private static final long serialVersionUID = 1L;

    @ManyToOne(cascade= CascadeType.ALL,fetch= FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Role roleId;

    @ManyToOne(cascade= CascadeType.ALL,fetch= FetchType.EAGER)
    @JoinColumn(name = "res_id")
    private Resource resId;

    @Override
    public String toString() {
        return "RoleResourcePK{" +
                "roleId=" + roleId +
                ", resId=" + resId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleResourcePK that = (RoleResourcePK) o;
        return Objects.equal(roleId, that.roleId) &&
                Objects.equal(resId, that.resId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(roleId, resId);
    }

    public RoleResourcePK(Role roleId, Resource resId) {
        this.roleId = roleId;
        this.resId = resId;
    }
}
