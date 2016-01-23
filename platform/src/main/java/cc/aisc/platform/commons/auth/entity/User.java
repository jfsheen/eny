package cc.aisc.platform.commons.auth.entity;

import cc.aisc.platform.commons.base.BaseEntity;
import cc.aisc.platform.commons.info.Person;
import cc.aisc.platform.utils.StringUtils;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.util.*;

/**
 * Created by sjf on 15-11-11.
 */
@Entity
@Table(name = "t_auth_user")
public class User extends BaseEntity<Long> {

    @Column(name =  "person_id")
    private Person person;

    @Column(name = "user_name", nullable = false, unique = true)
    private String username;

    @Column(name = "password_hash", nullable = false, columnDefinition = "")
    private String password;

    @Transient //todo:
    private String password1;

    @Column(name = "date_expired", columnDefinition = "timestamp default '2025-12-31'")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateExpired;

    @Column(name = "enabled", columnDefinition = "boolean default true")
    private Boolean enabled;

    @Column(name = "non_locked", columnDefinition = "boolean default true")
    private Boolean nonLocked;

    /**
     * JoinTable表示中间表
     * inverseJoinColumns表示关系被维护端对应的中间表的外键名
     * joinColumns表示关系维护端对应的中间表的外键名
     * @return
     */
    @ManyToMany(cascade={CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinTable(name="auth_user_group",
            inverseJoinColumns=@JoinColumn(name="group_id"),
            joinColumns=@JoinColumn(name="user_id"))
    private Set<Group> groups = new HashSet<Group>();



    @ManyToMany(cascade={CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinTable(name="auth_user_role",
            inverseJoinColumns=@JoinColumn(name="role_id"),
            joinColumns=@JoinColumn(name="user_id"))
    private Set<Role> roles = new HashSet<Role>();

    public User(String username, String password) {
        this.username = username;
        this.password = StringUtils.BCryptEncrypt(password);
    }

    public User(String username, String password, Date dateExpired, Boolean enabled, Boolean nonLocked) {
        this.username = username;
        this.password = StringUtils.BCryptEncrypt(password);
        this.dateExpired = dateExpired;
        this.enabled = enabled;
        this.nonLocked = nonLocked;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void addGroup(Group group){
        this.groups.add(group);
    }

    public void removeGroup(Group group){
        this.groups.remove(group);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = StringUtils.BCryptEncrypt(password);
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



    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public Person getPerson() {

        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<Group> getGroups() {

        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

    @Override
    public String toString() {
        return "User{" +
                "person=" + person +
                ", username='" + username + '\'' +
                ", dateExpired=" + dateExpired +
                ", enabled=" + enabled +
                ", nonLocked=" + nonLocked +
                ", password='" + StringUtils.BCryptEncrypt(password) + '\'' +
                ", groups=" + groups +
                ", roles=" + roles +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return Objects.equal(person, user.person) &&
                Objects.equal(username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), person, username, dateExpired, enabled, nonLocked, password, groups, roles);
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
