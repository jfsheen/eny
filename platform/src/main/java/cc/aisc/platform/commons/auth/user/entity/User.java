package cc.aisc.platform.commons.auth.user.entity;

import cc.aisc.platform.commons.auth.role.RoleEnum;
import cc.aisc.platform.commons.base.BaseEntity;
import cc.aisc.platform.commons.info.Person;
import com.google.common.base.*;
import com.google.common.base.Objects;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.Assert;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

/**
 * Created by sjf on 15-11-11.
 */
@Entity
@Table(name = "t_auth_user")
public class User extends BaseEntity<Long> {
        /*implements org.springframework.security.core.userdetails.UserDetails,
        org.springframework.security.core.CredentialsContainer {*/

    @Column(name =  "person_id")
    private Person person;

    @Column(name = "user_name", nullable = false, unique = true)
    private String username;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "date_expired", columnDefinition = "timestamp default '2025-12-31'")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateExpired;

    @Column(name = "enabled", columnDefinition = "boolean default true")
    private Boolean enabled;

    @Column(name = "non_locked", columnDefinition = "boolean default true")
    private Boolean nonLocked;


    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleEnum roleEnum;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "ugUser")
    private Set<UserGroup> userGroups = new HashSet<>();

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateExpired() {
        return dateExpired;
    }

    public void setDateExpired(Date dateExpired) {
        this.dateExpired = dateExpired;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getNonLocked() {
        return nonLocked;
    }

    public void setNonLocked(Boolean nonLocked) {
        this.nonLocked = nonLocked;
    }

    public String getUsername() {
        return username;
    }

    public User() {
    }

    public User(String email, String password, RoleEnum roleEnum) {
        this.email = email;
        this.passwordHash = new BCryptPasswordEncoder().encode(password);
        this.roleEnum = roleEnum;
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

    public RoleEnum getRoleEnum() {
        return roleEnum;
    }

    public void setRoleEnum(RoleEnum roleEnum) {
        this.roleEnum = roleEnum;
    }

    public Person getPerson() {

        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Set<UserGroup> getUserGroups() {
        return userGroups;
    }

    public void setUserGroups(Set<UserGroup> userGroups) {
        this.userGroups = userGroups;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "person=" + person +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", dateExpired=" + dateExpired +
                ", enabled=" + enabled +
                ", nonLocked=" + nonLocked +
                ", passwordHash='" + passwordHash + '\'' +
                ", roleEnum=" + roleEnum +
                ", userGroups=" + userGroups +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return com.google.common.base.Objects.equal(person, user.person) &&
                Objects.equal(username, user.username) &&
                Objects.equal(email, user.email) &&
                Objects.equal(password, user.password) &&
                Objects.equal(dateExpired, user.dateExpired) &&
                Objects.equal(enabled, user.enabled) &&
                Objects.equal(nonLocked, user.nonLocked) &&
                Objects.equal(passwordHash, user.passwordHash) &&
                Objects.equal(roleEnum, user.roleEnum) &&
                Objects.equal(userGroups, user.userGroups);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), person, username, email, password, dateExpired, enabled, nonLocked, passwordHash, roleEnum, userGroups);
    }


    /*private static final long serialVersionUID = 400L;

    @Column(name =  "person_id")
    private Person person;
    @Column(name = "password")
    private String password;
    @Column(name = "user_name", nullable = false, unique = true)
    private final String username;

    private final Set<GrantedAuthority> authorities;

    @Column(name = "date_expired", columnDefinition = "timestamp default '2025-12-31'")
    @Temporal(TemporalType.TIMESTAMP)
    private final Date accountExpiredDate;

    @Column(name = "non_locked", columnDefinition = "boolean default true")
    private final boolean accountNonLocked;


    private final boolean credentialsNonExpired;


    private final boolean enabled;

    public User(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        this(username, password, true, new Date("2025-12-31"), true, true, authorities);
    }

    public User(String username, String password, boolean enabled, Date accountExpiredDate, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        if(username != null && !"".equals(username) && password != null) {
            this.username = username;
            this.password = password;
            this.enabled = enabled;
            this.accountExpiredDate = accountExpiredDate;
            this.credentialsNonExpired = credentialsNonExpired;
            this.accountNonLocked = accountNonLocked;
            this.authorities = Collections.unmodifiableSet(sortAuthorities(authorities));
        } else {
            throw new IllegalArgumentException("Cannot pass null or empty values to constructor");
        }
    }

    public Collection<GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    public String getUsername() {
        return this.username;
    }

    public Date getAccountExpiredDate() {return this.accountExpiredDate;}

    public boolean isEnabled() {
        return this.enabled;
    }

    public boolean isAccountNonExpired() {
        return this.accountExpiredDate.after(new Date());
    }

    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    public void eraseCredentials() {
        this.password = null;
    }

    private static SortedSet<GrantedAuthority> sortAuthorities(Collection<? extends GrantedAuthority> authorities) {
        Assert.notNull(authorities, "Cannot pass a null GrantedAuthority collection");
        TreeSet sortedAuthorities = new TreeSet(new User.AuthorityComparator());
        Iterator var2 = authorities.iterator();

        while(var2.hasNext()) {
            GrantedAuthority grantedAuthority = (GrantedAuthority)var2.next();
            Assert.notNull(grantedAuthority, "GrantedAuthority list cannot contain any null elements");
            sortedAuthorities.add(grantedAuthority);
        }

        return sortedAuthorities;
    }

    @Override
    public boolean equals(Object rhs) {
        return rhs instanceof User?this.username.equals(((User)rhs).username):false;
    }

    @Override
    public int hashCode() {
        return this.username.hashCode();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(": ");
        sb.append("Username: ").append(this.username).append("; ");
        sb.append("Password: [PROTECTED]; ");
        sb.append("Enabled: ").append(this.enabled).append("; ");
        sb.append("AccountExpiredDate: ").append(this.accountExpiredDate).append("; ");
        sb.append("credentialsNonExpired: ").append(this.credentialsNonExpired).append("; ");
        sb.append("AccountNonLocked: ").append(this.accountNonLocked).append("; ");
        if(!this.authorities.isEmpty()) {
            sb.append("Granted Authorities: ");
            boolean first = true;
            Iterator var3 = this.authorities.iterator();

            while(var3.hasNext()) {
                GrantedAuthority auth = (GrantedAuthority)var3.next();
                if(!first) {
                    sb.append(",");
                }

                first = false;
                sb.append(auth);
            }
        } else {
            sb.append("Not granted any authorities");
        }

        return sb.toString();
    }

    private static class AuthorityComparator implements Comparator<GrantedAuthority>, Serializable {
        private static final long serialVersionUID = 400L;

        private AuthorityComparator() {
        }

        public int compare(GrantedAuthority g1, GrantedAuthority g2) {
            return g2.getAuthority() == null?-1:(g1.getAuthority() == null?1:g1.getAuthority().compareTo(g2.getAuthority()));
        }
    }*/




}
