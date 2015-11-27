package cc.aisc.platform.auth.user.entity;

import cc.aisc.platform.auth.role.Role;
import cc.aisc.platform.commons.base.BaseEntity;
import com.google.common.base.Objects;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;

/**
 * Created by sjf on 15-11-11.
 */
@Entity
@Table(name = "t_auth_user")
public class User extends BaseEntity<Long>{

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    public User() {
    }

    public User(String email, String password, Role role) {
        this.email = email;
        this.passwordHash = new BCryptPasswordEncoder().encode(password);
        this.role = role;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                ", role=" + role +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return Objects.equal(email, user.email) &&
                Objects.equal(passwordHash, user.passwordHash) &&
                Objects.equal(role, user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), email, passwordHash, role);
    }
}
