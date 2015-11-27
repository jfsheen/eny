package cc.aisc.platform.eny.customer.entity;

import cc.aisc.platform.commons.base.BaseEntity;
import cc.aisc.platform.commons.entity.Address;
import cc.aisc.platform.commons.entity.Contact;
import cc.aisc.platform.commons.entity.Person;
import cc.aisc.platform.eny.business.entity.Contract;
import com.google.common.base.Objects;

import javax.persistence.*;
import java.util.List;

/**
 * Created by sjf on 15-11-12.
 */
@Entity
@Table(name = "t_customer")
public class Customer extends BaseEntity<Long> {

    @Column(name = "customer_sn")
    private String customerSn;

    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "customer")
    private List<Contract> contracts;

    @Override
    public String toString() {
        return "Customer{" +
                "customerSn='" + customerSn + '\'' +
                ", person=" + person +
                ", description='" + description + '\'' +
                ", contracts=" + contracts +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Customer customer = (Customer) o;
        return Objects.equal(customerSn, customer.customerSn) &&
                Objects.equal(person, customer.person) &&
                Objects.equal(description, customer.description) &&
                Objects.equal(contracts, customer.contracts);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), customerSn, person, description, contracts);
    }

    public String getCustomerSn() {

        return customerSn;
    }

    public void setCustomerSn(String customerSn) {
        this.customerSn = customerSn;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }
}
