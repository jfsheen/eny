package cc.aisc.platform.eny.company.entity;

import cc.aisc.platform.commons.base.BaseEntity;
import cc.aisc.platform.commons.info.Address;
import com.google.common.base.Objects;

import javax.persistence.*;

/**
 * Created by sjf on 15-10-25.
 */
@Entity
@Table(name = "t_cmpy_department")
public class Department extends BaseEntity<Long> {

    @Column(name="department_sn")
    private String departmentSn;

    @Column(name="factory_name")
    private String name;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Agricola owner;

    @Column(name="scale_m2")
    private Integer scale_m2;

    @Column(name="staff_quantity")
    private Integer staffQuantity;

    @Column(name="description")
    private String description;

    @Override
    public String toString() {
        return "Factory{" +
                "departmentSn='" + departmentSn + '\'' +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", owner=" + owner +
                ", scale_m2=" + scale_m2 +
                ", staffQuantity=" + staffQuantity +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Department department = (Department) o;
        return Objects.equal(departmentSn, department.departmentSn) &&
                Objects.equal(name, department.name) &&
                Objects.equal(address, department.address) &&
                Objects.equal(owner, department.owner) &&
                Objects.equal(scale_m2, department.scale_m2) &&
                Objects.equal(staffQuantity, department.staffQuantity) &&
                Objects.equal(description, department.description);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), departmentSn, name, address, owner, scale_m2, staffQuantity, description);
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

    public Agricola getOwner() {
        return owner;
    }

    public void setOwner(Agricola owner) {
        this.owner = owner;
    }

    public Integer getSize_m2() {
        return scale_m2;
    }

    public void setSize_m2(Integer size_m2) {
        this.scale_m2 = size_m2;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getDepartmentSn() {

        return departmentSn;
    }

    public void setDepartmentSn(String departmentSn) {
        this.departmentSn = departmentSn;
    }
}
