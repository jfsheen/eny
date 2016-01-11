package cc.aisc.platform.commons.auth.dto;

import cc.aisc.platform.commons.auth.role.RoleEnum;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * Created by sjf on 15-11-11.
 */
public class UserCreateForm {
    @NotEmpty
    private String email = "";

    @NotEmpty
    private String password = "";

    @NotEmpty
    private String passwordRepeated = "";

    @NotNull
    private RoleEnum roleEnum = RoleEnum.USER;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordRepeated() {
        return passwordRepeated;
    }

    public void setPasswordRepeated(String passwordRepeated) {
        this.passwordRepeated = passwordRepeated;
    }

    public RoleEnum getRoleEnum() {
        return roleEnum;
    }

    public void setRoleEnum(RoleEnum roleEnum) {
        this.roleEnum = roleEnum;
    }

    @Override
    public String toString() {
        return "UserCreateForm{" +
                "email='" + email.replaceFirst("@.+", "@***") + '\'' +
                ", password=***" + '\'' +
                ", passwordRepeated=***" + '\'' +
                ", role=" + roleEnum +
                '}';
    }
}
