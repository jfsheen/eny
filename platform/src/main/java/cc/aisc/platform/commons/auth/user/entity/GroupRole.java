package cc.aisc.platform.commons.auth.user.entity;

import cc.aisc.platform.commons.base.BaseEntity;
import com.google.common.base.Objects;

import javax.persistence.*;

/**
 * Created by sjf on 15-12-1.
 */
@Entity
@Table(name = "t_auth_grprle")
public class GroupRole extends BaseEntity<Long> {

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "group_id")
    private Group grGroup;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Role grRole;

    @Override
    public String toString() {
        return "GroupRole{" +
                "grGroup=" + grGroup +
                ", grRole=" + grRole +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        GroupRole groupRole = (GroupRole) o;
        return Objects.equal(grGroup, groupRole.grGroup) &&
                Objects.equal(grRole, groupRole.grRole);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), grGroup, grRole);
    }

    public Group getGrGroup() {

        return grGroup;
    }

    public void setGrGroup(Group grGroup) {
        this.grGroup = grGroup;
    }

    public Role getGrRole() {
        return grRole;
    }

    public void setGrRole(Role grRole) {
        this.grRole = grRole;
    }
}
