package cc.aisc.platform.eny.company.entity;

import cc.aisc.platform.commons.base.BaseEntity;
import cc.aisc.platform.commons.info.Person;
import com.google.common.base.Objects;

import javax.persistence.*;

/**
 * Created by sjf on 15-11-27.
 */
@Entity
@Table(name = "t_cmpy_staff")
public class Staff extends BaseEntity<Long> {

    @Column(name = "staff_sn")
    private String staffSn;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id")
    private Person person;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "department_id")
    private Department department;
    @Column(name = "position")
    private String position;
    @Column(name = "description")
    private String description;

    @Override
    public String toString() {
        return "Staff{" +
                "staffSn='" + staffSn + '\'' +
                ", person=" + person +
                ", department='" + department + '\'' +
                ", position='" + position + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Staff staff = (Staff) o;
        return Objects.equal(staffSn, staff.staffSn) &&
                Objects.equal(person, staff.person) &&
                Objects.equal(department, staff.department) &&
                Objects.equal(position, staff.position) &&
                Objects.equal(description, staff.description);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), staffSn, person, department, position, description);
    }

    public String getStaffSn() {

        return staffSn;
    }

    public void setStaffSn(String staffSn) {
        this.staffSn = staffSn;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
