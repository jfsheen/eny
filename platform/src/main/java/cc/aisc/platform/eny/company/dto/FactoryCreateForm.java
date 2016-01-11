package cc.aisc.platform.eny.company.dto;

import cc.aisc.platform.commons.info.Address;
import com.google.common.base.Objects;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * Created by sjf on 15-11-18.
 */
public class FactoryCreateForm {

    @NotEmpty
    private String name;

    @NotNull
    private Address address;

    @NotNull
    private Long ownerId;

    @NotNull
    private Integer scale_m2;

    @NotNull
    private Integer staffQuantity;

    @NotEmpty
    private String description;

    @Override
    public String toString() {
        return "FactoryCreateForm{" +
                "name='" + name + '\'' +
                ", address=" + address +
                ", ownerId=" + ownerId +
                ", scale_m2=" + scale_m2 +
                ", staffQuantity=" + staffQuantity +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FactoryCreateForm that = (FactoryCreateForm) o;
        return Objects.equal(name, that.name) &&
                Objects.equal(address, that.address) &&
                Objects.equal(ownerId, that.ownerId) &&
                Objects.equal(scale_m2, that.scale_m2) &&
                Objects.equal(staffQuantity, that.staffQuantity) &&
                Objects.equal(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name, address, ownerId, scale_m2, staffQuantity, description);
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public Integer getScale_m2() {
        return scale_m2;
    }

    public void setScale_m2(Integer scale_m2) {
        this.scale_m2 = scale_m2;
    }

    public Integer getStaffQuantity() {
        return staffQuantity;
    }

    public void setStaffQuantity(Integer staffQuantity) {
        this.staffQuantity = staffQuantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
