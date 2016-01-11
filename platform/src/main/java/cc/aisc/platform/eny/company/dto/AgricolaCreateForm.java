package cc.aisc.platform.eny.company.dto;

import cc.aisc.platform.commons.info.Gender;
import com.google.common.base.Objects;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by sjf on 15-11-17.
 */
public class AgricolaCreateForm {

    @Size(min = 4, max = 20, message = "name error.")
    private String name = "";
    @Pattern(regexp = "^(\\+86)?1([\\d]{10})$", message = "password error.")
    private String cellphone = "";
    @NotEmpty(message = "password error.")
    private String password = "";
    @NotEmpty(message = "password error.")
    private String passwordRepeat = "";
    @Email(message = "email error.")
    private String email = "";
    @Pattern(regexp = "[1-9][0-9]{4,13}", message = "qq error.")
    private String qq = "";
    @NotNull(message = "gender error.")
    private Gender gender = Gender.MALE;

    @Override
    public String toString() {
        return "AgricolaCreateForm{" +
                "name='" + name + '\'' +
                ", cellphone='" + cellphone + '\'' +
                ", password='" + password + '\'' +
                ", passwordRepeat='" + passwordRepeat + '\'' +
                ", email='" + email + '\'' +
                ", qq='" + qq + '\'' +
                ", gender=" + gender +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AgricolaCreateForm that = (AgricolaCreateForm) o;
        return Objects.equal(name, that.name) &&
                Objects.equal(cellphone, that.cellphone) &&
                Objects.equal(password, that.password) &&
                Objects.equal(passwordRepeat, that.passwordRepeat) &&
                Objects.equal(email, that.email) &&
                Objects.equal(qq, that.qq) &&
                Objects.equal(gender, that.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name, cellphone, password, passwordRepeat, email, qq, gender);
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordRepeat() {
        return passwordRepeat;
    }

    public void setPasswordRepeat(String passwordRepeat) {
        this.passwordRepeat = passwordRepeat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
