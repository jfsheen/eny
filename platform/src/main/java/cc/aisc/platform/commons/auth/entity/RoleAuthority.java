package cc.aisc.platform.commons.auth.entity;

import cc.aisc.platform.commons.base.CPKBaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by sjf on 16-1-11.
 */
@Entity
@Table(name = "auth_role_authority")
public class RoleAuthority extends CPKBaseEntity<RoleResourcePK>{

    /*@Column(name = "can_access")
    private Boolean canAccess;

    @Override
    public String toString() {
        return "RoleAuthority{" +
                "canAccess=" + canAccess +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        RoleAuthority that = (RoleAuthority) o;
        return Objects.equal(canAccess, that.canAccess);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), canAccess);
    }

    public Boolean getCanAccess() {

        return canAccess;
    }

    public void setCanAccess(Boolean canAccess) {
        this.canAccess = canAccess;
    }*/
}
