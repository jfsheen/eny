package cc.aisc.platform.eny.business.entity;

import cc.aisc.platform.commons.base.BaseEntity;
import cc.aisc.platform.eny.customer.entity.Customer;
import cc.aisc.platform.eny.company.entity.Department;
import com.google.common.base.Objects;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by sjf on 15-11-12.
 */
@Entity
@Table(name = "t_biz_contract")
public class Contract extends BaseEntity<Long> {

    @Column(name = "contract_sn")
    private String contractSn;

    @ManyToOne
    @JoinColumn(name = "buyer")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "seller")
    private Department department;

    @Column(name="sign_date")
    @Temporal(TemporalType.DATE)
    private Date signDate;

    @Column(name="deadline")
    @Temporal(TemporalType.DATE)
    private Date deadline;

    @OneToMany(mappedBy = "contract", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private Set<Deal> dealSet;

    @OneToOne(mappedBy = "contract", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private Invoice invoice;

    @Override
    public String toString() {
        return "Contract{" +
                "contractSn='" + contractSn + '\'' +
                ", customer=" + customer +
                ", factory=" + department +
                ", signDate=" + signDate +
                ", deadline=" + deadline +
                ", dealSet=" + dealSet +
                ", invoice=" + invoice +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contract contract = (Contract) o;
        return Objects.equal(contractSn, contract.contractSn) &&
                Objects.equal(customer, contract.customer) &&
                Objects.equal(department, contract.department) &&
                Objects.equal(signDate, contract.signDate) &&
                Objects.equal(deadline, contract.deadline) &&
                Objects.equal(dealSet, contract.dealSet) &&
                Objects.equal(invoice, contract.invoice);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(contractSn, customer, department, signDate, deadline, dealSet, invoice);
    }

    public String getContractSn() {

        return contractSn;
    }

    public void setContractSn(String contractSn) {
        this.contractSn = contractSn;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Set<Deal> getDealSet() {
        return dealSet;
    }

    public void setDealSet(Set<Deal> dealSet) {
        this.dealSet = dealSet;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
}
