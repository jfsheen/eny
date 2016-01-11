package cc.aisc.platform.eny.company.entity;

import cc.aisc.platform.commons.base.BaseEntity;
import cc.aisc.platform.commons.info.Person;
import com.google.common.base.Objects;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by sjf on 15-11-27.
 */
@Entity
@Table(name="t_cmpy")
public class Company extends BaseEntity<Long> {

    @Column(name = "name")
    private String name;

    @Column(name = "license_no")
    private String licenseNo;

    @JoinColumn(name = "legel_person_id")
    private Person legelPerson;

    @Column(name = "reg_capital")
    private Double regCapital;

    @Column(name = "paidup_capital")
    private Double paidupCapital;

    @Column(name = "char_biz")
    private String characterOfBiz;

    @Column(name = "scope_biz")
    private String scopeOfOperation;

    @Column(name = "date_foundation")
    @Temporal(TemporalType.DATE)
    private Date dateFoundation;

    @Column(name = "term_from")
    @Temporal(TemporalType.DATE)
    private Date dateTermFrom;

    @Column(name = "term_to")
    @Temporal(TemporalType.DATE)
    private Date dateTermTo;

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", licenseNo='" + licenseNo + '\'' +
                ", legelPerson=" + legelPerson +
                ", regCapital=" + regCapital +
                ", paidupCapital=" + paidupCapital +
                ", characterOfBiz='" + characterOfBiz + '\'' +
                ", scopeOfOperation='" + scopeOfOperation + '\'' +
                ", dateFoundation=" + dateFoundation +
                ", dateTermFrom=" + dateTermFrom +
                ", dateTermTo=" + dateTermTo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Company company = (Company) o;
        return Objects.equal(name, company.name) &&
                Objects.equal(licenseNo, company.licenseNo) &&
                Objects.equal(legelPerson, company.legelPerson) &&
                Objects.equal(regCapital, company.regCapital) &&
                Objects.equal(paidupCapital, company.paidupCapital) &&
                Objects.equal(characterOfBiz, company.characterOfBiz) &&
                Objects.equal(scopeOfOperation, company.scopeOfOperation) &&
                Objects.equal(dateFoundation, company.dateFoundation) &&
                Objects.equal(dateTermFrom, company.dateTermFrom) &&
                Objects.equal(dateTermTo, company.dateTermTo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), name, licenseNo, legelPerson, regCapital, paidupCapital, characterOfBiz, scopeOfOperation, dateFoundation, dateTermFrom, dateTermTo);
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLicenseNo() {

        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public Person getLegelPerson() {
        return legelPerson;
    }

    public void setLegelPerson(Person legelPerson) {
        this.legelPerson = legelPerson;
    }

    public Double getRegCapital() {
        return regCapital;
    }

    public void setRegCapital(Double regCapital) {
        this.regCapital = regCapital;
    }

    public Double getPaidupCapital() {
        return paidupCapital;
    }

    public void setPaidupCapital(Double paidupCapital) {
        this.paidupCapital = paidupCapital;
    }

    public String getCharacterOfBiz() {
        return characterOfBiz;
    }

    public void setCharacterOfBiz(String characterOfBiz) {
        this.characterOfBiz = characterOfBiz;
    }

    public String getScopeOfOperation() {
        return scopeOfOperation;
    }

    public void setScopeOfOperation(String scopeOfOperation) {
        this.scopeOfOperation = scopeOfOperation;
    }

    public Date getDateFoundation() {
        return dateFoundation;
    }

    public void setDateFoundation(Date dateFoundation) {
        this.dateFoundation = dateFoundation;
    }

    public Date getDateTermFrom() {
        return dateTermFrom;
    }

    public void setDateTermFrom(Date dateTermFrom) {
        this.dateTermFrom = dateTermFrom;
    }

    public Date getDateTermTo() {
        return dateTermTo;
    }

    public void setDateTermTo(Date dateTermTo) {
        this.dateTermTo = dateTermTo;
    }
}
