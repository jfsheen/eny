package cc.aisc.platform.commons.info;

import cc.aisc.platform.commons.base.BaseEntity;
import com.google.common.base.Objects;

import javax.persistence.*;

/**
 * Created by sjf on 15-10-25.
 */
@Entity
@Table(name = "t_cms_contact")
public class Contact extends BaseEntity<Long> {
    @Column
    @Enumerated(EnumType.STRING)
    private ContactType contactType;
    @Column
    private String contact;
    @Column
    private String remark;
    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id")
    private Person person;

    public Contact(ContactType type, String contact, String remark, Person person){
        this.contactType = type;
        this.contact = contact;
        this.remark = remark;
        this.person = person;
    }
    public Contact(){}

    @Override
    public String toString() {
        return "Contact{" +
                "contactType='" + contactType + '\'' +
                ", contact='" + contact + '\'' +
                ", remark='" + remark + '\'' +
                ", person=" + person +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Contact contact1 = (Contact) o;
        return Objects.equal(contactType, contact1.contactType) &&
                Objects.equal(contact, contact1.contact) &&
                Objects.equal(remark, contact1.remark) &&
                Objects.equal(person, contact1.person);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), contactType, contact, remark, person);
    }

    public ContactType getContactType() {
        return contactType;
    }

    public void setContactType(ContactType contactType) {
        this.contactType = contactType;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
