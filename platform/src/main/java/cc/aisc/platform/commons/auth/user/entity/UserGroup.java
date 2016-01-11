package cc.aisc.platform.commons.auth.user.entity;

import cc.aisc.platform.commons.base.BaseEntity;
import com.google.common.base.Objects;

import javax.persistence.*;

/**
 * Created by sjf on 15-12-1.
 */
@Entity
@Table(name = "t_auth_usrgrp")
public class UserGroup extends BaseEntity<Long> {

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "group_id")
    private Group ugGroup;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User ugUser;

    @Override
    public String toString() {
        return "UserGroup{" +
                "ugGroup=" + ugGroup +
                ", ugUser=" + ugUser +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        UserGroup userGroup = (UserGroup) o;
        return Objects.equal(ugGroup, userGroup.ugGroup) &&
                Objects.equal(ugUser, userGroup.ugUser);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), ugGroup, ugUser);
    }

    public Group getUgGroup() {

        return ugGroup;
    }

    public void setUgGroup(Group ugGroup) {
        this.ugGroup = ugGroup;
    }

    public User getUgUser() {
        return ugUser;
    }

    public void setUgUser(User ugUser) {
        this.ugUser = ugUser;
    }
}
