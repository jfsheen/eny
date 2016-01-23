package cc.aisc.platform.commons.auth.dto;

import cc.aisc.platform.commons.auth.RoleEnum;
import cc.aisc.platform.utils.StringUtils;
import com.google.common.base.Objects;
import org.apache.commons.lang3.time.DateUtils;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by sjf on 15-11-11.
 */
public class UserDto {

    @NotEmpty
    private String username = "";

    @NotEmpty
    private String password = "";

    @NotEmpty
    private String pssword1 = "";

    //todo set default expired date to 2025-12-31
    @NotEmpty
    private Date dateExpired = DateUtils.setYears(new Date(), 2020);

    @NotEmpty
    private Boolean enabled = true;

    @NotEmpty
    private Boolean nonLocked = true;

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

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public String getPasswordHash() {
        return StringUtils.BCryptEncrypt(password);
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPssword1() {
        return pssword1;
    }

    public void setPssword1(String pssword1) {
        this.pssword1 = pssword1;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", dateExpired=" + dateExpired +
                ", enabled=" + enabled +
                ", nonLocked=" + nonLocked +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return Objects.equal(username, userDto.username) &&
                Objects.equal(password, userDto.password) &&
                Objects.equal(dateExpired, userDto.dateExpired) &&
                Objects.equal(enabled, userDto.enabled) &&
                Objects.equal(nonLocked, userDto.nonLocked);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(username, password, dateExpired, enabled, nonLocked);
    }
}
